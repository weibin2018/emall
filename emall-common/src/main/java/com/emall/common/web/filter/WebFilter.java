package com.emall.common.web.filter;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.log.LogUtils;
import com.emall.common.utils.Base64;
import com.emall.common.utils.DateUtils;
import com.emall.common.utils.HostUtils;
import com.emall.common.utils.JsonUtils;
import com.emall.common.web.constant.WebConstants;
import com.emall.common.web.model.MessageEntity;
import com.emall.common.web.model.ResponseCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

import static com.emall.common.utils.HttpUtils.getHeader;
import static com.emall.common.web.constant.WebConstants.METHOD_GET;

/**
 * @ClassName WebFilter
 * @Description web 请求拦截器
 * @Author weibin
 * @Date 2018/11/23 16:09
 * @Version 1.0
 **/
public class WebFilter extends GenericFilterBean {

    private final String TRACE_REQUEST_BODY = "request.body";
    private final String TRACE_RESPONSE_BODY = "response.body";
    //todo 后续补充
    //private Tracer tracer;
//    public WebFilter(Tracer tracer) {
//        this.tracer = tracer;
//    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Long beginTime = DateUtils.getNowTime();
        try{
            // 初始化MDC信息
            mdc(request,response);
            boolean tracerFlag = true;
            //todo 后续补充
//            if (null == this.tracer || !HttpUtils.shouldTracer(request, response)) {
//                tracerFlag = false;
//            }
            // 包装ServletRequest
            TraceServletRequestWrapper requestWrapper = new TraceServletRequestWrapper(request);
            // 包装ServletResponse
            TraceServletResponseWrapper responseWrapper = new TraceServletResponseWrapper(response);
            filterChain.doFilter(requestWrapper, responseWrapper);
            printInfo(requestWrapper,responseWrapper,beginTime,tracerFlag);
        }catch (Exception e){
            LogUtils.errorLog("请求URI["+request.getRequestURI()+"]异常",e);
            throw new ApplicationException(ResponseCode.UNKOWN_EXCEPTION);
        }
    }

    /**
     *@Description 打印请求信息
     *@Param [request, response, beginTime]
     *@Author weibin
     *@Date 2018/11/23 17:25
     *@Return void
     **/
    private void printInfo(TraceServletRequestWrapper requestWrapper,TraceServletResponseWrapper responseWrapper,
                           long beginTime,boolean tracerFlag) throws JsonProcessingException {
        Long endTime  = DateUtils.getNowTime();
        // 跟踪请求参数
        String requestBody = traceRequestParam(requestWrapper, tracerFlag);
        // 跟踪相应参数
        String responseBody = traceResponseParam(responseWrapper, tracerFlag);
        MessageEntity entity = new MessageEntity();
        entity.setRequestBody(requestBody)
                .setResponseBody(responseBody)
                .setBeginTime(String.valueOf(beginTime))
                .setEndTime(String.valueOf(endTime))
                .setTimeConsuming(String.valueOf(((endTime - beginTime))));
        LogUtils.infoLog(JsonUtils.serialize(entity));
    }

    private String  traceRequestParam(TraceServletRequestWrapper requestWrapper,Boolean tracerFlag){
        String body = "";
        String method = requestWrapper.getMethod();
        // 处理GET请求参数
        if (method.equalsIgnoreCase(METHOD_GET)) {
            body = requestWrapper.getQueryString();
            if (!StringUtils.isEmpty(body) && Base64.isBase64(body)) {
                body = Base64.decode(body);
            }
        } else {
            // 处理POST请求参数
            TraceServletInputStream traceInputStream = requestWrapper.getTraceInputStream();
            if (traceInputStream != null) {
                body = new String(traceInputStream.getContent().getBytes(), StandardCharsets.UTF_8);
            }
        }
        if (!StringUtils.isEmpty(body)) {
            if(tracerFlag) {
                //todo 后续补充
                //this.tracer.addTag(TRACE_REQUEST_BODY, body);
            }
        }
        return body;
    }

    private String  traceResponseParam(TraceServletResponseWrapper responseWrapper,Boolean tracerFlag){
        TraceServletOutputStream traceOutputStream = responseWrapper.getTraceOutputStream();
        if (null != traceOutputStream && !StringUtils.isEmpty(traceOutputStream.getContent())) {
            String response = new String(traceOutputStream.getContent().getBytes(), StandardCharsets.UTF_8);
            if(tracerFlag) {
                //todo 后续补充
                //this.tracer.addTag(TRACE_RESPONSE_BODY, response);
            }
            return response;
        }
        return  null;
    }

    /**
     * 增加Log MDC 参数
     * @param request
     * @param response
     */
    private void mdc( HttpServletRequest request,HttpServletResponse response){
        String traceId = getHeader(request, WebConstants.TRACE_ID);
        // 日志跟踪id
        MDC.put("traceId",traceId);
        // 远程IP
        MDC.put("remoteIP",getHeader(request,WebConstants.X_REAL_IP));
        // 请求URL
        MDC.put("requestURL",getHeader(request,WebConstants.X_SPAN_NAME));
        // 会话ID
        MDC.put("sessionId",getHeader(request, WebConstants.X_SESSION_ID));
        //主机名
        MDC.put("serverName",HostUtils.hostName());
        // 主机IP
        String ip = HostUtils.getIp();
        MDC.put("serverIp",ip);
        // spanId
        String spanId = getHeader(request, WebConstants.X_SPAN_ID);
        if(StringUtils.isEmpty(spanId)){
            spanId = traceId;
        }else{
            ip = ip.substring(ip.lastIndexOf(".")+1);
            spanId = spanId+"_"+ip;
        }
        MDC.put(WebConstants.X_SPAN_PARENT_ID,spanId);
    }

}

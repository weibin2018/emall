package com.emall.common.web.filter;

import com.emall.common.log.LogUtils;
import com.emall.common.utils.Base64;
import com.emall.common.utils.DateUtils;
import com.emall.common.utils.JsonUtils;
import com.emall.common.web.filter.stream.TraceServletInputStream;
import com.emall.common.web.filter.stream.TraceServletOutputStream;
import com.emall.common.web.filter.wrapper.TraceServletRequestWrapper;
import com.emall.common.web.filter.wrapper.TraceServletResponseWrapper;
import com.emall.common.web.model.MessageEntity;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

import static com.emall.common.web.constant.WebConstants.METHOD_GET;

/**
 * @ClassName PrintMessage
 * @Description 输出请求信息及应答信息
 * @Author weibin
 * @Date 2018/12/12 18:58
 * @Version 1.0
 **/
public final class PrintMessage {

    /**
     *@Description 打印请求信息
     *@Param [request, response, beginTime]
     *@Author weibin
     *@Date 2018/11/23 17:25
     *@Return void
     **/
    public static void printInfo(TraceServletRequestWrapper requestWrapper,
                                 TraceServletResponseWrapper responseWrapper,long beginTime){
        Long endTime  = DateUtils.getNowTime();
        // 跟踪请求参数
        String requestBody = traceRequestParam(requestWrapper);
        // 跟踪相应参数
        String responseBody = traceResponseParam(responseWrapper);
        MessageEntity entity = new MessageEntity();
        entity.setRequestBody(requestBody)
                .setResponseBody(responseBody)
                .setBeginTime(String.valueOf(beginTime))
                .setEndTime(String.valueOf(endTime))
                .setTimeConsuming(String.valueOf(((endTime - beginTime))));
        LogUtils.infoLog(JsonUtils.serialize(entity));
    }

    private static String  traceRequestParam(TraceServletRequestWrapper requestWrapper){
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
        return body;
    }

    private static String  traceResponseParam(TraceServletResponseWrapper responseWrapper){
        TraceServletOutputStream traceOutputStream = responseWrapper.getTraceOutputStream();
        if (null != traceOutputStream && !StringUtils.isEmpty(traceOutputStream.getContent())) {
            String response = new String(traceOutputStream.getContent().getBytes(), StandardCharsets.UTF_8);
            return response;
        }
        return  null;
    }
}

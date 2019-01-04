package com.emall.zull.filter;

import com.emall.utils.HttpUtils;
import com.emall.web.constant.WebConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName RequestFilter
 * @Description 请求信息过滤器,处理所有请求
 * @Author weibin
 * @Date 2018/12/20 20:50
 * @Version 1.0
 **/
@Component
public class RequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        HttpServletRequest request = ctx.getRequest();
        //设置请求头
        setHeader(request,response);
        //用户token获取及鉴权

        //权限控制

        //数据解密
        return true;
    }

    /**
     *@Description 设置请求头
     *@Param [request, response]
     *@Author weibin
     *@Date 2018/12/20 21:14
     *@Return void
     **/
    private void setHeader(HttpServletRequest request,HttpServletResponse response){
        String traceId = HttpUtils.createTraceId();
        String remoteIp = HttpUtils.getRealIP(request);
        String sessionId = request.getRequestedSessionId();
        response.setHeader(WebConstants.TRACE_ID,traceId);
        response.setHeader(WebConstants.X_REAL_IP,remoteIp);
        response.setHeader(WebConstants.X_SESSION_ID,sessionId);
        // 日志跟踪id
        MDC.put(WebConstants.TRACE_ID,traceId);
        // 请求URL
        MDC.put(WebConstants.REQUEST_URI,request.getRequestURI());
        // 会话ID
        MDC.put(WebConstants.X_SESSION_ID,sessionId);
        //远程客户端IP
        MDC.put(WebConstants.REMOTE_IP,remoteIp);
    }
}

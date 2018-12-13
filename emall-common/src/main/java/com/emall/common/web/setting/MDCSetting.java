package com.emall.common.web.setting;

import com.emall.common.core.spring.SpringContext;
import com.emall.common.utils.HostUtils;
import com.emall.common.utils.HttpUtils;
import com.emall.common.web.constant.WebConstants;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static com.emall.common.utils.HttpUtils.getHeader;

/**
 * @ClassName MDCConfig
 * @Description slf4j MDC日志，用于日志输出
 * @Author weibin
 * @Date 2018/12/12 18:17
 * @Version 1.0
 **/
public final class MDCSetting {

    private MDCSetting(){}

    /**
     *@Description 增加Log MDC 参数 设置
     *@Param [request]
     *@Author weibin
     *@Date 2018/12/12 18:19
     *@Return void
     **/
    public static void mdc(HttpServletRequest request){
        // 日志跟踪id
        String traceId = getHeader(request, WebConstants.TRACE_ID);
        if(StringUtils.isEmpty(traceId))
            traceId = HttpUtils.createTraceId();
        MDC.put(WebConstants.TRACE_ID,traceId);
        // 远程IP
        MDC.put(WebConstants.REMOTE_IP,getHeader(request,WebConstants.X_REAL_IP));
        // 请求URL
        MDC.put(WebConstants.REQUEST_URI,request.getRequestURI());
        // 会话ID
        MDC.put(WebConstants.X_SESSION_ID,getHeader(request, WebConstants.X_SESSION_ID));
        // 主机IP
        MDC.put(WebConstants.LOCAL,HostUtils.getIp());
        // spanId
        MDC.put(WebConstants.X_SPAN_ID,HttpUtils.createTraceId());
        // X-Span-Name 工作单元名称
        MDC.put(WebConstants.X_SPAN_NAME, SpringContext.getApplicationName());
        // X-B3-ParentSpanId
        MDC.put(WebConstants.X_SPAN_PARENT_ID,getHeader(request, WebConstants.X_SPAN_PARENT_ID));
    }
}

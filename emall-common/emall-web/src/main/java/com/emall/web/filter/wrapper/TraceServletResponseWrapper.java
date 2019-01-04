package com.emall.web.filter.wrapper;

import com.emall.utils.HttpUtils;
import com.emall.web.filter.stream.TraceServletOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName TraceServletResponseWrapper
 * @Description trace 应答包装类
 * @Author weibin
 * @Date 2018/11/23 16:09
 * @Version 1.0
 **/
public class TraceServletResponseWrapper extends HttpServletResponseWrapper {
    private TraceServletOutputStream traceOutputStream;
    private HttpServletResponse response;

    public TraceServletResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        // 如果响应头的ContentType不符合规则则直接返回
        if(!HttpUtils.shouldTracer(null, response)) {
            return super.getOutputStream();
        }
        // 拦截响应流,获取响应body
        if (null == traceOutputStream) {
            traceOutputStream = new TraceServletOutputStream(super.getOutputStream());
        }
        return traceOutputStream;
    }

    /**
     * @return the traceOutputStream
     */
    public TraceServletOutputStream getTraceOutputStream() {
        return traceOutputStream;
    }

}

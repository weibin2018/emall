package com.emall.common.web.filter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * @ClassName TraceServletRequestWrapper
 * @Description trace 请求包装类
 * @Author weibin
 * @Date 2018/11/23 16:09
 * @Version 1.0
 **/
public class TraceServletRequestWrapper extends HttpServletRequestWrapper {

    TraceServletInputStream traceInputStream;

    public TraceServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (traceInputStream == null) {
            traceInputStream = new TraceServletInputStream(super.getInputStream());
        }
        return traceInputStream;
    }

    public TraceServletInputStream getTraceInputStream() {
        return traceInputStream;
    }
}

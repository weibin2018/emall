package com.emall.web.filter;


import com.emall.log.LogUtils;
import com.emall.utils.DateUtils;
import com.emall.utils.JsonUtils;
import com.emall.web.filter.wrapper.TraceServletRequestWrapper;
import com.emall.web.filter.wrapper.TraceServletResponseWrapper;
import com.emall.web.model.ResponseData;
import com.emall.web.setting.MDCSetting;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @ClassName WebFilter
 * @Description web 请求拦截器
 * @Author weibin
 * @Date 2018/11/23 16:09
 * @Version 1.0
 **/
public class WebFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Long beginTime = DateUtils.getNowTime();
        try{
            MDCSetting.mdc(request);
            // 包装ServletRequest
            TraceServletRequestWrapper requestWrapper = new TraceServletRequestWrapper(request);
            // 包装ServletResponse
            TraceServletResponseWrapper responseWrapper = new TraceServletResponseWrapper(response);
            filterChain.doFilter(requestWrapper, responseWrapper);
            PrintMessage.printInfo(requestWrapper,responseWrapper,beginTime);
        }catch (Exception e){
            LogUtils.errorLog("请求异常",e);
            writeMsg(response);
        }
    }

    /**
     *@Description 写入应答信息
     *@Param [response, responseCode]
     *@Author weibin
     *@Date 2018/12/17 15:26
     *@Return void
     **/
    private void writeMsg(HttpServletResponse response){
        try {
            Writer writer = response.getWriter();
            writer.write(JsonUtils.serialize(new ResponseData()));
        } catch (IOException e) {
            LogUtils.errorLog("写入应答信息异常",e);
        }
    }
}

package com.emall.common.web.filter;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.log.LogUtils;
import com.emall.common.utils.DateUtils;
import com.emall.common.web.filter.wrapper.TraceServletRequestWrapper;
import com.emall.common.web.filter.wrapper.TraceServletResponseWrapper;
import com.emall.common.web.model.ResponseCode;
import com.emall.common.web.setting.MDCSetting;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throw new ApplicationException(ResponseCode.UNKOWN_EXCEPTION);
        }
    }
}

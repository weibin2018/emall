package com.emall.web.config;

import com.emall.web.filter.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConfig
 * @Description fiter 过滤器
 * @Author weibin
 * @Date 2018/12/11 18:52
 * @Version 1.0
 **/
@Configuration
public class FilterConfig {

    /**
     *@Description 注册过滤器
     *@Param []
     *@Author weibin
     *@Date 2018/12/11 18:54
     *@Return FilterRegistrationBean
     **/
    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WebFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
}

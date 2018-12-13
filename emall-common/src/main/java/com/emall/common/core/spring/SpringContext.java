package com.emall.common.core.spring;

import com.emall.common.constant.Constant;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName SpringContext
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/13 17:44
 * @Version 1.0
 **/
public final class SpringContext{

    private static ConfigurableApplicationContext applicationContext;

    public static ConfigurableApplicationContext getContext() {
        return applicationContext;
    }

    public static void setContext(ConfigurableApplicationContext context) {
        applicationContext = context;
    }

    public static String getApplicationName(){
        return applicationContext.getEnvironment().getProperty(Constant.SPRING_APPLICATION_NAME);
    }
}

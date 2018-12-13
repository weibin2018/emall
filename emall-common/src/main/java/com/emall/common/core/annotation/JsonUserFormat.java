package com.emall.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName JsonUserFormat
 * @Description 人员信息注解
 * @Author weibin
 * @Date 2018/12/7 20:21
 * @Version 1.0
 **/
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonUserFormat {
}


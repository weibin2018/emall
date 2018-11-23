package com.emall.common.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName PropertyAnnotation
 * @Description 指定需要使用的对象属性注解
 * @Author weibin
 * @Date 2018/11/23 14:58
 * @Version 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PropertyAnnotation {

    /** 返回给前端属性 */
    String[] includes() default {};

    /** 排除属性 */
    String[] excludes() default {};

    Class<?> clazz() default Void.class;
}

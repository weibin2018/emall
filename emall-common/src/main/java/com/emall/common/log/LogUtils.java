package com.emall.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName LogUtils
 * @Description 日志记录工具类
 * @Author weibin
 * @Date 2018/11/23 15:15
 * @Version 1.0
 **/
public final class LogUtils {

    /**
     * 类的私有构造函数
     */
    private LogUtils(){}

    /**
     * 日志类
     */
    private static final Logger log = LoggerFactory.getLogger(LogUtils.class);

    /**
     * 存储错误日志
     * @param msg 提示信息
     * @param e  异常
     */
    public static void errorLog(String msg,Throwable e){
        log.error(msg,e);
    }


    /**
     * 存放info级别的日志信息
     * @param msg 提示信息
     */
    public static void infoLog(String msg){
        log.info(msg);
    }

    /**
     * 存放警告级别的日志信息
     * @param msg 提示信息
     */
    public static void warnLog(String msg){
        log.warn(msg);
    }

    /**
     * 存放debug级别日志信息
     * @param msg 提示信息
     */
    public static void debugLog(String msg){
        log.debug(msg);
    }
}

package com.emall.web.constant;


import com.emall.core.constant.Constant;

/**
 * @ClassName WebConstants
 * @Description web 常量设置
 * @Author weibin
 * @Date 2018/11/23 15:02
 * @Version 1.0
 **/
public class WebConstants extends Constant {
    /**
     * traceId
     */
    public static final String TRACE_ID = "X-trace-id";
    /**
     * sessionId
     */
    public static final String X_SESSION_ID = "X-session-id";
    /**
     * 所有请头
     */
    public static final String REQUEST_HEADER = "request_header";
    /**
     * 用户信息
     */
    public static final String THREAD_USERINFO_CONTEXT = "Thread_user";

    /** ip **/
    public static final String X_REAL_IP = "X-real-ip";
    public static final String X_SPAN_ID = "X-span-id";
    public static final String X_SPAN_NAME = "X-span-name";
    public static final String X_SPAN_PARENT_ID = "X-parent-span-id";
    /**
     * 计算机名称
     */
    public static final String X_COMPUTERNAME = "X-ComputerName";
    /**
     * 网卡地址
     */
    public static final String X_NETWORKCARD  = "X-NetworkCard";
    /**
     * 主板编码
     */
    public static final String X_MAINBOARDNO = "X-MainBoardNo";
    /**
     * 导出
     */
    public static final String X_EXPORT = "X-Export";
    /** 远程服务器IP **/
    public static final String REMOTE_IP = "X-remote-ip";
    /** 本次请求URI **/
    public static final String REQUEST_URI = "X-request-uri";
    /** 本机IP **/
    public static final String LOCAL = "local";

}
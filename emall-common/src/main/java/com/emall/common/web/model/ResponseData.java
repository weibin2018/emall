package com.emall.common.web.model;

import com.emall.common.web.constant.WebConstants;
import org.slf4j.MDC;

import java.io.Serializable;

import static com.emall.common.web.model.ResponseCode.UNKOWN_EXCEPTION;

/**
 * @ClassName ResponseData
 * @Description http请求应答报文
 * @Author weibin
 * @Date 2018/11/23 15:20
 * @Version 1.0
 **/
public class ResponseData<T> implements Serializable {

    /** 错误或者成功代码 */
    private int code;
    /** 错误描述 */
    private String msg;
    /** 响应结果*/
    private T data;
    /**当前请求URI**/
    private String uri;
    /**分布式请求traceId**/
    private String traceId;
    /**本次请求spanId**/
    private String spanId;
    /**本机IP**/
    private String ip;

    /**
     * 构造函数
     */
    public ResponseData() {
        this(UNKOWN_EXCEPTION);
    }

    /**
     * 构造函数
     * @param code    错误或者成功代码
     * @param message 错误描述
     */
    public ResponseData(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    /**
     * 构造函数
     * @param code    错误或者成功代码
     * @param message 错误描述
     * @param data    响应结果
     *
     */
    public ResponseData(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    /**
     * 构造函数
     */
    public ResponseData(AppCode appCode) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
    }


    /**
     * 构造函数
     */
    public ResponseData(AppCode appCode, T data) {
        this.code = appCode.getCode();
        this.msg = appCode.getMessage();
        this.data = data;
    }


    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }
    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    /**
     * @return the data
     */
    public T getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public ResponseData setData(T data) {
        this.data = data;
        return this;
    }

    public void responseCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ResponseData<T> ok() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMessage();
        return this;
    }

    public String getUri() {
        return MDC.get(WebConstants.REQUEST_URI);
    }

    public String getSpanId() {
        return MDC.get(WebConstants.X_SPAN_ID);
    }

    public String getIp() {
        return MDC.get(WebConstants.LOCAL);
    }

    /**
     * @return the traceId
     */
    public String getTraceId() {
        return MDC.get(WebConstants.TRACE_ID);
    }

    /**
     * 成功返回true
     * @return
     */
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }
}

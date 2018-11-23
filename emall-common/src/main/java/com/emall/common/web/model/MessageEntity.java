package com.emall.common.web.model;

import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @ClassName MessageEntity
 * @Description 消息体
 * @Author weibin
 * @Date 2018/11/23 17:29
 * @Version 1.0
 **/
public class MessageEntity implements Serializable {

    //请求信息
    private String requestBody;
    //应答报文
    private String responseBody;
    //请求开始时间
    private String beginTime;
    //请求结束时间
    private String endTime;
    //耗时
    private String timeConsuming;

    public MessageEntity(){}

    public String getRequestBody() {
        return requestBody;
    }

    public MessageEntity setRequestBody(String requestBody) {
        if(StringUtils.isEmpty(requestBody)){
            requestBody = "{}";
        }
        this.requestBody = requestBody;
        return this;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public MessageEntity setResponseBody(String responseBody) {
        if(StringUtils.isEmpty(responseBody)){
            responseBody="{}";
        }
        this.responseBody = responseBody;
        return this;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public MessageEntity setBeginTime(String beginTime) {
        this.beginTime = beginTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public MessageEntity setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    public String getTimeConsuming() {
        return timeConsuming;
    }

    public MessageEntity setTimeConsuming(String timeConsuming) {
        this.timeConsuming = timeConsuming;
        return this;
    }
}

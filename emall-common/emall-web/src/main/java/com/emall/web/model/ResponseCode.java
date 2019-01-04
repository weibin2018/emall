package com.emall.web.model;

import com.emall.core.model.AppCode;

/**
 * @ClassName ResponseCode
 * @Description http请求应答报文状态码
 * @Author weibin
 * @Date 2018/11/23 15:21
 * @Version 1.0
 **/
public enum ResponseCode implements AppCode {

    GET_LOCAL_INFO_EXCEPTION(4,"获取本机信息异常"),
    RESOURCE_NOT_FOUND(404, "请求资源不存在"),
    UNKOWN_EXCEPTION(500, "系统压力山大,请稍后重试！"),
    CONNECT_EXCEPTION(504,"请求服务超时"),
    ROUTE_EXCEPTION(503,"后端服务不可用"),
    SUCCESS(0, "OK"),
    INSERT_EXCEPTION(10, "新增数据失败！"),
    INSERT_BATCH_EXCEPTION(11, "批量新增数据失败！"),
    UPDATE_EXCEPTION(20, "更新数据失败！"),
    DELETE_EXCEPTION(30, "删除数据失败！"),
    DELETE_BATCH_EXCEPTION(31, "批量删除数据失败！"),
    DISABLE_EXCEPTION(32, "禁用数据失败！"),
    DISABLE_BATCH_EXCEPTION(33, "批量禁用数据失败！"),
    SELECT_ONE_EXCEPTION(40, "数据获取失败！"),
    SELECT_EXCEPTION(41, "数据获取失败！"),
    SELECT_PAGINATION_EXCEPTION(42, "数据获取失败！");

    private int code;
    private String message;

    private ResponseCode(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return Integer.toString(getCode());
    }
}

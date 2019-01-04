package com.emall.core.model;

/**
 * @ClassName AppCode
 * @Description 系统业务代码
 * @Author weibin
 * @Date 2018/11/23 15:21
 * @Version 1.0
 **/
public interface AppCode {

    int getCode();
    void setCode(int code);

    String getMessage();
    void setMessage(String message);

    default boolean isSuccess() {
        return this.getCode() == 0;
    }
}

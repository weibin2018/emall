package com.emall.core.exception;

import com.emall.core.model.AppCode;

/**
 * @ClassName ApplicationException
 * @Description 应用异常包装类
 * @Author weibin
 * @Date 2018/11/23 16:37
 * @Version 1.0
 **/
public class ApplicationException extends RuntimeException{

    private AppCode appCode;

    public ApplicationException() {}

    public ApplicationException(AppCode appCode){
        super(appCode.getMessage());
        this.appCode = appCode;
    }

    public ApplicationException(AppCode appCode, Object... msgArgs) {
        super(String.format(appCode.getMessage(), msgArgs));
        this.appCode = appCode;
    }

    public ApplicationException(int code, String message) {
        this(code, message, (Throwable)null);
    }

    public ApplicationException(int code, String message, Throwable cause) {
        super(message, cause);
        this.appCode = new DefaultAppCode(code, message);
    }

    public AppCode getAppCode() {
        return this.appCode;
    }

    public void setAppCode(AppCode appCode) {
        this.appCode = appCode;
    }

    class DefaultAppCode implements AppCode {
        private int code;
        private String message;

        public DefaultAppCode(int code, String message) {
            this.setCode(code);
            this.setMessage(message);
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}

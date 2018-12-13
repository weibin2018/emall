package com.emall.common.web.controller;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.log.LogUtils;
import com.emall.common.web.model.ResponseCode;
import com.emall.common.web.model.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ResourceNotFoundController
 * @Description 请求异常处理
 * @Author weibin
 * @Date 2018/11/23 15:02
 * @Version 1.0
 **/
@ControllerAdvice
public class ResourceNotFoundController{

    /**
     * 系统异常处理，比如：404,500
     * @param request
     * @param e
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest request, Exception e){
        LogUtils.errorLog("请求异常",e);
        ResponseData responseData = new ResponseData();
        responseData.setMsg(e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            responseData.setCode(ResponseCode.RESOURCE_NOT_FOUND.getCode());
        }else if(e instanceof ApplicationException){
            responseData.setCode(((ApplicationException) e).getAppCode().getCode());
        }else {
            responseData.setCode(ResponseCode.UNKOWN_EXCEPTION.getCode());
        }
        return responseData;
    }

}

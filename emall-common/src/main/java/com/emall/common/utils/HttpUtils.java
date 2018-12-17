package com.emall.common.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.emall.common.web.constant.WebConstants.*;

/**
 * @ClassName HttpUtils
 * @Description http 相关操作工具类
 * @Author weibin
 * @Date 2018/11/23 16:23
 * @Version 1.0
 **/
public class HttpUtils {

    /**
     *@Description 得到请求头中的信息
     *@Param [request, name]
     *@Author weibin
     *@Date 2018/11/23 16:23
     *@Return java.lang.String
     **/
    public static String getHeader(HttpServletRequest request, String name){
        String value =  request.getHeader(name);
        if(StringUtils.isEmpty(value)){
            return "";
        }else{
            return value;
        }
    }

    /**
     *@Description 判断是否包装过滤请求
     *    当request时，tracer请求体类型为application/x-www-form-urlencoded,application/json,text/xml的请求
     *    当response时，tracer响应体类型为text/xml,text/plain,application/json的响应
     *@Param [request, response]
     *@Author weibin
     *@Date 2018/11/23 16:12
     *@Return boolean
     **/
    public static boolean shouldTracer(HttpServletRequest request, HttpServletResponse response) {
        boolean tracerFlag = false;
        if (null != request) {
            // request请求为GET时默认tracer
            if(METHOD_GET.equalsIgnoreCase(request.getMethod())) {
                return true;
            }
            String requestContentType = request.getHeader(CONTENT_TYPE);
            // 判断请求头的CONTENT_TYPE是否符合规则
            if (!StringUtils.isEmpty(requestContentType)) {
                String[] acceptContentTypes = REQUEST_ACCEPT_CONTENT_TYPE.split(SEPARATOR_STR);
                for (String acceptContentType: acceptContentTypes) {
                    if(requestContentType.contains(acceptContentType)) {
                        return true;
                    }
                }
            }
        }
        if(null != response) {
            String responseContentType = response.getContentType();
            // 判断响应头的CONTENT_TYPE是否符合规则
            if (!StringUtils.isEmpty(responseContentType)) {
                String[] acceptContentTypes = RESPONSE_ACCEPT_CONTENT_TYPE.split(SEPARATOR_STR);
                for (String acceptContentType: acceptContentTypes) {
                    if(responseContentType.contains(acceptContentType)) {
                        return true;
                    }
                }
            }
        }
        return tracerFlag;
    }

    /**
     *@Description 生成一个traceId
     *@Param []
     *@Author weibin
     *@Date 2018/12/12 17:03
     *@Return java.lang.String
     **/
    public static String createTraceId(){
        return RandomUtils.rundom(8);
    }
}

package com.emall.zull.callback;

import com.emall.log.LogUtils;
import com.emall.utils.JsonUtils;
import com.emall.web.model.ResponseCode;
import com.emall.web.model.ResponseData;
import com.netflix.client.ClientException;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @ClassName ServerFallback
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/20 17:10
 * @Version 1.0
 **/
@Component
public class ServerFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";  //所有服务路由
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        LogUtils.errorLog("网关调用后端服务异常",cause);
       if(cause instanceof HystrixTimeoutException){
           return response(HttpStatus.GATEWAY_TIMEOUT,ResponseCode.CONNECT_EXCEPTION.getMessage());
       }else if(cause instanceof ClientException){
           return response(HttpStatus.SERVICE_UNAVAILABLE,ResponseCode.ROUTE_EXCEPTION.getMessage());
       }else{
           return response(HttpStatus.INTERNAL_SERVER_ERROR,ResponseCode.UNKOWN_EXCEPTION.getMessage());
       }
    }

    private ClientHttpResponse response(final HttpStatus status,final String message) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode(){
                return status;
            }

            @Override
            public int getRawStatusCode(){
                return status.value();
            }

            @Override
            public String getStatusText(){
                return message;
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody(){
                return new ByteArrayInputStream(JsonUtils.serialize(new ResponseData(status.value(),message)).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}

package com.emall.zull.filter;

import com.emall.core.constant.Constant;
import com.emall.log.LogUtils;
import com.emall.utils.JsonUtils;
import com.emall.web.constant.WebConstants;
import com.emall.web.model.ResponseData;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomerErrorFilter
 * @Description 自定义错误处理
 * @Author weibind
 * @Date 2018/12/17 15:40
 * @Version 1.0
 **/
@Component
public class CustomerErrorFilter extends ZuulFilter {

    private static final String ERROR_KEY = "throwable";

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().containsKey(ERROR_KEY);
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable e = (Exception) ctx.get(ERROR_KEY);
        ctx.remove(ERROR_KEY); // 删除该异常信息,不然在下一个过滤器中还会被执行处理
        LogUtils.errorLog("网关处理请求异常",e);
        writeResponseData(new ResponseData(),ctx);
        return null;
    }

    /**
     *@Description 设置应答信息
     *@Param [responseData,ctx]
     *@Author weibin
     *@Date 2018/12/17 18:13
     *@Return void
     **/
    private void writeResponseData(ResponseData responseData,RequestContext ctx){
        ctx.setResponseBody(JsonUtils.serialize(responseData));
        HttpServletResponse response = ctx.getResponse();
        response.setContentType(WebConstants.RESPONSE_ACCEPT_CONTENT_TYPE);
        response.setCharacterEncoding(Constant.UTF8);
    }
}

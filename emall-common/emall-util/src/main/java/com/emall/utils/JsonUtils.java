package com.emall.utils;

import com.emall.log.LogUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @ClassName JsonUtils
 * @Description json 序列化 /反序列化 工具类
 * @Author weibin
 * @Date 2018/11/23 17:38
 * @Version 1.0
 **/
public class JsonUtils {

    /**
     *@Description json 序列化
     *@Param [param]
     *@Author weibin
     *@Date 2018/11/23 17:42
     *@Return java.lang.String
     **/
    public static String serialize(Object param){
        if(null == param)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(param);
        }catch (Exception e){
            LogUtils.errorLog("json序列化失败",e);
            return null;
        }
    }

    /**
     *@Description json 反序列化
     *@Param [param, tClass]
     *@Author weibin
     *@Date 2018/11/23 17:47
     *@Return java.lang.Object
     **/
    public static Object deserialize(String param,Class tClass){
        if(StringUtils.isEmpty(param))
            return null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(param, tClass);
        }catch (Exception e){
            LogUtils.errorLog("json反序列化失败",e);
            return null;
        }
    }
}

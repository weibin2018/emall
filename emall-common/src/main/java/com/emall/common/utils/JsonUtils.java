package com.emall.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;

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
    public static String serialize(Object param) throws JsonProcessingException {
        if(null == param)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(param);
    }

    /**
     *@Description json 反序列化
     *@Param [param, tClass]
     *@Author weibin
     *@Date 2018/11/23 17:47
     *@Return java.lang.Object
     **/
    public static Object deserialize(String param,Class tClass) throws IOException {
        if(StringUtils.isEmpty(param))
            return null;
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(param, tClass);
    }
}

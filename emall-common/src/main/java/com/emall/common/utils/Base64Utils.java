package com.emall.common.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName Base64Utils
 * @Description base64 处理
 * @Author weibin
 * @Date 2018/11/23 18:04
 * @Version 1.0
 **/
public class Base64{

    /**
     *@Description 验证字符串是否是base64编码
     *@Param [str]
     *@Author weibin
     *@Date 2018/11/23 18:05
     *@Return boolean
     **/
    public static boolean isBase64(String str){
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            if (str.length() % 4 != 0) {
                return false;
            }
            char[] strChars = str.toCharArray();
            for (char c:strChars) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
                        || c == '+' || c == '/' || c == '=') {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     *@Description base64 解码
     *@Param [String]
     *@Author weibin
     *@Date 2018/11/23 18:08
     *@Return java.lang.String
     **/
    public static String decode(String str){
        return new String(Base64Utils.decodeFromString(str),StandardCharsets.UTF_8);
    }

    /**
     *@Description base64 转码
     *@Param [String]
     *@Author weibin
     *@Date 2018/11/23 18:08
     *@Return java.lang.String
     **/
    public static String encode(String str){
        return Base64Utils.encodeToString(str.getBytes());
    }
}

package com.emall.common.utils;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.log.LogUtils;
import com.emall.common.web.model.ResponseCode;

import java.net.InetAddress;

/**
 * @ClassName HostUtils
 * @Description 本机相关信息获取工具类
 * @Author weibin
 * @Date 2018/11/23 16:30
 * @Version 1.0
 **/
public class HostUtils {

    private static InetAddress addr = null;

    /**
     *@Description 获取本机信息
     *@Param
     *@Author weibin
     *@Date 2018/11/23 16:33
     *@Return java.net.InetAddress
     **/
    public static InetAddress getInetAddress(){
        try{
            if(null == addr){
                addr = InetAddress.getLocalHost();
            }
            return addr;
        }catch (Exception e){
            LogUtils.errorLog("获取本机信息异常",e);
            throw new ApplicationException(ResponseCode.GET_LOCAL_INFO_EXCEPTION);
        }
    }

    /**
     *@Description 获取本机的主机名称
     *@Param
     *@Author weibin
     *@Date 2018/11/23 16:31
     *@Return java.lang.String
     **/
    public static String hostName(){
        return getInetAddress().getHostName();
    }
    /**
     *@Description 获取本机IP
     *@Param
     *@Author weibin
     *@Date 2018/11/23 16:43
     *@Return java.lang.String
     **/
    public static String getIp(){
        return getInetAddress().getHostAddress();
    }
}

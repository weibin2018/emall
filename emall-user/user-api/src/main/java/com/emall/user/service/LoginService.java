package com.emall.user.service;

import com.emall.user.model.UserInfo;

/**
 * @ClassName LoginService
 * @Description 用户登录服务接口
 * @Author weibin
 * @Date 2018/11/26 21:43
 * @Version 1.0
 **/
public interface LoginService {

    /**
     *@Description 用户登录
     *@Param userInfo 用户信息
     *@Author weibin
     *@Date 2018/12/7 14:24
     *@Return com.emall.user.model.UserInfo ，成功返回用户信息，失败返回异常提示
     **/
    UserInfo doLogin(UserInfo userInfo);
}

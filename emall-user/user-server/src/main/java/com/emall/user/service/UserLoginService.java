package com.emall.user.service;

import com.emall.common.web.service.IBaseService;

/**
 * @ClassName UserLoginService
 * @Description 用户登录服务
 * @Author weibin
 * @Date 2018/12/7 18:26
 * @Version 1.0
 **/
public interface UserLoginService<UserInfo> extends IBaseService<UserInfo> {

    /**
     *@Description 用户登录
     *@Param [userInfo]
     *@Author weibin
     *@Date 2018/12/11 17:13
     *@Return void
     **/
    void doLogin(UserInfo userInfo);
}

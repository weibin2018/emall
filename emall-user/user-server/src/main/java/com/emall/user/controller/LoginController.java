package com.emall.user.controller;

import com.emall.common.web.controller.AbstractController;
import com.emall.common.web.model.ResponseData;
import com.emall.user.model.UserInfo;
import com.emall.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/7 15:01
 * @Version 1.0
 **/
@RestController
public class LoginController extends AbstractController {

    @Autowired
    private LoginService loginService;

    /**
     *@Description 用户登录
     *@Param [userInfo]
     *@Author weibin
     *@Date 2018/12/7 15:04
     *@Return com.emall.common.web.model.ResponseData<com.emall.user.model.UserInfo>
     **/
    @PostMapping("/doLogin")
    public ResponseData<UserInfo> doLogin(UserInfo userInfo){
        userInfo = this.loginService.doLogin(userInfo);
        ResponseData<UserInfo> responseData = new ResponseData<>();
        return responseData.setData(userInfo).ok();
    }
}

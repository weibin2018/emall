package com.emall.user.controller;

import com.emall.common.web.controller.AbstractController;
import com.emall.common.web.model.ResponseData;
import com.emall.user.model.UserInfo;
import com.emall.user.service.RemoteLoginService;
import com.emall.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/7 15:01
 * @Version 1.0
 **/
@RestController
public class LoginController extends AbstractController implements RemoteLoginService {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public ResponseData<UserInfo> doLogin(@RequestBody UserInfo userInfo) {
        this.userLoginService.doLogin(userInfo);
        ResponseData<UserInfo> responseData = new ResponseData<>();
        return responseData.ok();
    }
}

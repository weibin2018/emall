package com.emall.user.controller;

import com.emall.common.web.controller.AbstractController;
import com.emall.common.web.model.ResponseData;
import com.emall.user.model.UserInfo;
import com.emall.user.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/7 15:01
 * @Version 1.0
 **/
@RestController
public class LoginController extends AbstractController implements LoginService{

    @Override
    public ResponseData<UserInfo> doLogin(@RequestBody UserInfo userInfo) {

        return null;
    }
}

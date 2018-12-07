package com.emall.user.service.impl;

import com.emall.user.model.UserInfo;
import com.emall.user.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/7 14:17
 * @Version 1.0
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public UserInfo doLogin(UserInfo userInfo) {
        return new UserInfo(){{setAccount("11111");}};
    }
}

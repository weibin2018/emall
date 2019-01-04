package com.emall.user.service.impl;

import com.emall.core.exception.ApplicationException;
import com.emall.user.mapper.UserMapper;
import com.emall.user.service.UserLoginService;
import com.emall.utils.JsonUtils;
import com.emall.web.model.ResponseCode;
import com.emall.web.service.impl.IbaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserLoginServiceImpl
 * @Description TODO
 * @Author weibin
 * @Date 2018/12/11 17:13
 * @Version 1.0
 **/
@Service
public class UserLoginServiceImpl<UserInfo> extends IbaseServiceImpl<UserMapper<UserInfo>,UserInfo> implements UserLoginService<UserInfo> {

    @Autowired
    private UserMapper<UserInfo> userMapper;

    @Override
    public UserMapper<UserInfo> getMapper() {
        return userMapper;
    }

    @Override
    public void doLogin(UserInfo userInfo){
        if(null == userInfo)
            throw new ApplicationException(ResponseCode.SELECT_ONE_EXCEPTION);
    }

}

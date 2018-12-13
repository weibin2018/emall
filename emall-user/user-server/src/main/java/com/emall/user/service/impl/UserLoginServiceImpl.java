package com.emall.user.service.impl;

import com.emall.common.core.exception.ApplicationException;
import com.emall.common.utils.JsonUtils;
import com.emall.common.web.model.ResponseCode;
import com.emall.common.web.service.impl.IbaseServiceImpl;
import com.emall.user.mapper.UserMapper;
import com.emall.user.service.UserLoginService;
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
        System.out.println(JsonUtils.serialize(userInfo));
    }

}

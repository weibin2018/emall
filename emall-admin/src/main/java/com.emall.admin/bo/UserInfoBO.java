package com.emall.admin.bo;

import com.emall.web.model.GenericBO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName UserInfoBO
 * @Description TODO
 * @Author weibin
 * @Date 2019/1/4 16:11
 * @Version 1.0
 **/
@Data
public class UserInfoBO extends GenericBO {

    @NotNull(message = "账号不可以为空")
    private String account;
    @NotNull(message = "密码不可以为空")
    private String password;

}

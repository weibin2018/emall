package com.emall.admin.system;

import com.emall.web.controller.AbstractController;
import com.emall.web.model.ResponseData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description 后台用户登录
 * @Author weibin
 * @Date 2019/1/2 17:54
 * @Version 1.0
 **/
@RestController
public class LoginController extends AbstractController {

    public ResponseData<String> doLogin(@RequestBody ){

    }
}

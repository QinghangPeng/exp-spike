package com.exp.spike.controller;

import com.exp.spike.result.RestResponse;
import com.exp.spike.service.LoginService;
import com.exp.spike.vo.LoginVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @ClassName: LoginController
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 21:39
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/login")
@Api(tags = "登录")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public RestResponse<Boolean> doLogin(@Valid LoginVo vo) {
        return service.doLogin(vo);
    }

}

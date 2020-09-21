package com.exp.spike.controller;

import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.result.RestResponse;
import com.exp.spike.service.BasicService;
import com.exp.spike.service.GoodsService;
import com.exp.spike.service.LoginService;
import com.exp.spike.vo.LoginVo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @ClassName: LoginController
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 21:39
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/goods")
@Api(tags = "商品列表")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/to_list")
    public String toList(Model model,
                         MiaoshaUser user) {
        return goodsService.toList(model,user);
    }


}

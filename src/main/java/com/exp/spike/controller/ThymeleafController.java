package com.exp.spike.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ThymeleafController
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-25 22:26
 * @Version: 1.0
 **/
@Controller
@Api(tags = "thymeleaf模板回传数据")
public class ThymeleafController {

    @GetMapping("/test/thymeleaf")
    public String getThymeleaf(Model model) {
        model.addAttribute("name","Jackson");
        return "hello";
    }

}

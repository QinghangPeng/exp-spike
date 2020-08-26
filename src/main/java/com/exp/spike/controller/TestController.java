package com.exp.spike.controller;

import com.exp.spike.dao.OrdersDao;
import com.exp.spike.result.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: TestController
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-25 21:28
 * @Version: 1.0
 **/
@RestController
@Api(tags = "测试")
public class TestController {

    @Resource
    private OrdersDao dao;

    @GetMapping("/test")
    @ApiOperation("测试")
    public RestResponse<String> test(@RequestParam("id") String id) {
        return RestResponse.success(dao.getById(id));
    }

}

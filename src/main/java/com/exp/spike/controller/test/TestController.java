package com.exp.spike.controller.test;

import com.exp.spike.dao.OrdersDao;
import com.exp.spike.result.RestResponse;
import com.exp.spike.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    @PostMapping("/test/jsr303")
    @ApiOperation("校验jsr303对除去String外的参数校验")
    public RestResponse<Boolean> testJsr303(@Valid TestVo vo) {
        return RestResponse.success(true);
    }

}

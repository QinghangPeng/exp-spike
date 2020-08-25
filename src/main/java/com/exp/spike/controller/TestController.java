package com.exp.spike.controller;

import com.exp.spike.result.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    @ApiOperation("测试")
    public RestResponse<String> test() {
        return RestResponse.success("hello world");
    }

}

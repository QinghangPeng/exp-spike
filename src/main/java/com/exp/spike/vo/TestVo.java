package com.exp.spike.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: TestVo
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-16 21:57
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class TestVo {

    @NotNull
    private Integer a;

    @NotNull
    private Long b;


}

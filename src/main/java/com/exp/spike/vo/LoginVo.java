package com.exp.spike.vo;

import com.exp.spike.validator.isMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: LoginVo
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 22:30
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
@ApiModel("登录实体")
@ToString
public class LoginVo {

    @NotBlank
    @isMobile
    @ApiModelProperty("用户名")
    private String mobile;

    @NotBlank
    @Length(min = 32)
    @ApiModelProperty("密码")
    private String password;

}

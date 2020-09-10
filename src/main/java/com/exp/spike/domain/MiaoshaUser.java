package com.exp.spike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: User
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 22:49
 * @Version: 1.0
 **/
@Data
@NoArgsConstructor
public class MiaoshaUser {

    private Long id;
    private String nickname;
    private String password;
    private String salt;
    private String head;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;

}

package com.exp.spike.service;

import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.error.ServiceError;
import com.exp.spike.exception.GlobalException;
import com.exp.spike.redis.MiaoshaUserKey;
import com.exp.spike.result.RestResponse;
import com.exp.spike.util.Md5Util;
import com.exp.spike.util.RedisUtil;
import com.exp.spike.util.UUIDUtil;
import com.exp.spike.util.ValidatorUtil;
import com.exp.spike.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginService
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 22:38
 * @Version: 1.0
 **/
@Service
@Slf4j
public class LoginService {

    @Autowired
    private MiaoshaUserService service;
    @Autowired
    private BasicService basicService;
    /**
     *  登录
     * @param vo
     * @return
     */
    public RestResponse<Boolean> doLogin(HttpServletResponse response,LoginVo vo) {
        //参数校验
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        //登录
        MiaoshaUser user = service.getByNickname(mobile);
        if (user == null) {
            throw new GlobalException(ServiceError.MOBILE_OR_PASSWORD_ERROR);
        }
        //验证密码
        String calcPass = Md5Util.formPassToDBPass(password, user.getSalt());
        if (!calcPass.equals(user.getPassword())) {
            throw new GlobalException(ServiceError.MOBILE_OR_PASSWORD_ERROR);
        }
        //生成cookie
        String token = UUIDUtil.uuid();
        basicService.addCookie(response,user,token);
        return RestResponse.success(true);
    }

}

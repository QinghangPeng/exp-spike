package com.exp.spike.service;

import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.redis.MiaoshaUserKey;
import com.exp.spike.util.RedisUtil;
import com.exp.spike.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: BasicService
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-21 20:49
 * @Version: 1.0
 **/
@Service
@Slf4j
public class BasicService {

    @Autowired
    private RedisUtil redisUtil;

    public static final String COOKIE_NAME_TOKEN = "token";

    /**
     *  添加cookie
     * @param response
     * @param user
     */
    public void addCookie(HttpServletResponse response, MiaoshaUser user,String token) {
        redisUtil.set(MiaoshaUserKey.token,token,user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN,token);
        cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}

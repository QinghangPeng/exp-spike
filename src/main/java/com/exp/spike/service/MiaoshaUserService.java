package com.exp.spike.service;

import com.exp.spike.dao.MiaoshaUserDao;
import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.redis.MiaoshaUserKey;
import com.exp.spike.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: MiaoshaUserService
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 22:55
 * @Version: 1.0
 **/
@Service
@Slf4j
public class MiaoshaUserService {

    @Resource
    private MiaoshaUserDao dao;
    @Autowired
    private RedisUtil redisUtil;

    public MiaoshaUser getById(long id) {
        return dao.getById(id);
    }

    public MiaoshaUser getByNickname(String mobile) {
        return dao.getByNickname(mobile);
    }

    public MiaoshaUser getByToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return redisUtil.get(MiaoshaUserKey.token,token,MiaoshaUser.class);
    }

}

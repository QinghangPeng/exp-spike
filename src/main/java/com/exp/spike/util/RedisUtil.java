package com.exp.spike.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisUtil
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-30 22:45
 * @Version: 1.0
 **/
@Component
@Slf4j
public class RedisUtil {

    @Resource
    private RedisTemplate<String,String> template;

    /**
     *  获取值
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key,Class<T> clazz) {
        String str = template.opsForValue().get(key);
        T t = stringToBean(str, clazz);
        return t;
    }

    /**
     *  插入值
     * @param key
     * @param value
     * @param expireTime 根据传入的值判断是否设置ttl
     * @param <T>
     * @return
     */
    public <T> boolean set(String key,Long expireTime,T value) {
        String str = beanToString(value);
        if (expireTime <= 0) {
            template.opsForValue().set(key,str);
        } else {
            template.opsForValue().set(key,str, expireTime, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     *  判断可以是否存在
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(String key) {
        Boolean ifKeyExists = template.hasKey(key);
        return ifKeyExists;
    }

    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        return JSON.toJSONString(value);
    }

    private <T> T stringToBean(String value,Class<T> clazz) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        T t = JSONObject.parseObject(value, clazz);
        return t;
    }
}

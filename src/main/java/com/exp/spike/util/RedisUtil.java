package com.exp.spike.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exp.spike.redis.KeyPrefix;
import com.sun.org.apache.regexp.internal.RE;
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
     * 获取值
     * @param prefix key前缀,用于判断是哪个模块
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz) {
        String realKey = getRealKey(prefix, key);
        String str = template.opsForValue().get(realKey);
        T t = stringToBean(str, clazz);
        return t;
    }

    /**
     * 插入值
     * @param prefix key前缀,用于判断是哪个模块
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix prefix,String key, T value) {
        String realKey = getRealKey(prefix, key);
        String str = beanToString(value);
        if (StringUtils.isBlank(str)) {
            return false;
        }
        int expireTime = prefix.expireSeconds();
        if (expireTime <= 0) {
            template.opsForValue().set(realKey,str);
        } else {
            template.opsForValue().set(realKey,str, expireTime, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     *  判断key是否存在
     * @param prefix key前缀,用于判断是哪个模块
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix prefix,String key) {
        String realKey = getRealKey(prefix, key);
        Boolean ifKeyExists = template.hasKey(realKey);
        return ifKeyExists;
    }

    /**
     *  自增
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long incr(KeyPrefix prefix,String key) {
        String realKey = getRealKey(prefix, key);
        Long increment = template.opsForValue().increment(realKey, 1L);
        return increment;
    }

    /**
     *  自减
     * @param prefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> Long decr(KeyPrefix prefix,String key) {
        String realKey = getRealKey(prefix, key);
        Long decrement = template.opsForValue().increment(realKey, -1L);
        return decrement;
    }

    /**
     *  实体转string
     * @param value
     * @param <T>
     * @return
     */
    private <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        return JSON.toJSONString(value);
    }

    /**
     *  string转实体
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    private <T> T stringToBean(String value,Class<T> clazz) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        T t = JSONObject.parseObject(value, clazz);
        return t;
    }

    /**
     *  获取真正的key
     * @param prefix
     * @param key
     * @return
     */
    private String getRealKey(KeyPrefix prefix,String key) {
        return prefix.getPrefix() + key;
    }
}

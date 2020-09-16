package com.exp.spike.redis;

/**
 * @ClassName: KeyPrefix
 * @Description: redis通用缓存key封装
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-08 21:13
 * @Version: 1.0
 **/
public interface KeyPrefix {

    /**
     *  过期时间
     * @return
     */
    int expireSeconds();

    /**
     *  前缀
     * @return
     */
    String getPrefix();

}

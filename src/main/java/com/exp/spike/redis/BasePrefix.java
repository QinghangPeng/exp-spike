package com.exp.spike.redis;

/**
 * @ClassName: BasePrefix
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-08 21:17
 * @Version: 1.0
 **/
public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;
    private String prefix;

    /**
     *  默认构造永不过期的redis key前缀
     * @param prefix
     */
    public BasePrefix(String prefix) {
        this(0,prefix);
    }

    /**
     *  构造带过期时间的redis key前缀
     * @param expireSeconds
     * @param prefix
     */
    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        //默认0代表永不过期
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        //为了保证key不重复,获取类名加上前缀
        String simpleName = getClass().getSimpleName();
        return simpleName + ":" +prefix;
    }

}

package com.exp.spike.redis;

/**
 * @ClassName: MiaoshaUserKey
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-17 00:30
 * @Version: 1.0
 **/
public class MiaoshaUserKey extends BasePrefix {

    private static final int TOKEN_EXPIRE = 3600*24*2;

    public MiaoshaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MiaoshaUserKey token = new MiaoshaUserKey(TOKEN_EXPIRE,"tk");

}

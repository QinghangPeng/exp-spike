package com.exp.spike.util;

import java.util.UUID;

/**
 * @ClassName: UUIDUtil
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-17 00:26
 * @Version: 1.0
 **/
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-","");
    }

}

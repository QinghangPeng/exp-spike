package com.exp.spike.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: ValidatorUtil
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-10 22:43
 * @Version: 1.0
 **/
public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /**
     *  验证是否为手机号
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(mobile);
        return m.matches();
    }

}

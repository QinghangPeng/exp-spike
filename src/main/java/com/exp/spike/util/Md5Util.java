package com.exp.spike.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @ClassName: Md5Util
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-08 22:36
 * @Version: 1.0
 **/
public class Md5Util {

    /**
     *  固定salt
     */
    private static String SALT = "1a2b3c4d";

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     *  第一次md5
     * @param pass
     * @return
     */
    public static String inputPassToFormPass(String pass) {
        String str = SALT.charAt(0) + SALT.charAt(2) + pass + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    /**
     *  第二次md5
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass,String salt) {
        String str = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     *  两次md5
     * @param input
     * @param dbSalt
     * @return
     */
    public static String inputPassToDBPass(String input,String dbSalt) {
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass, dbSalt);
        return dbPass;
    }

}

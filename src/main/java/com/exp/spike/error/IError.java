package com.exp.spike.error;

/**
 * @ClassName: IError
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-25 21:49
 * @Version: 1.0
 **/
public interface IError {

    /**
     *  获取编码code
     * @return
     */
    String getErrorCode();

    /**
     *  获取错误信息
     * @return
     */
    String getErrorMsg();

}

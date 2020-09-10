package com.exp.spike.error;

/**
 * @ClassName: ServiceError
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-25 21:51
 * @Version: 1.0
 **/
public enum ServiceError implements IError {

    /**
     * 用于未定义错误
     */
    UN_KNOW_NULL("00000001", "未知错误"),
    PASSWORD_EMPTY("00000002","登录密码不能为空"),
    MOBILE_EMPTY("00000003","手机号不能为空"),
    MOBILE_ERROR("00000004","手机号码格式错误"),
    MOBILE_OR_PASSWORD_ERROR("00000005","用户名或者密码错误"),
    /**
     *  用于自定义错误
     */
    DISPLAY_ERROR("",""),


    ;

    String code;
    String msg;

    /**
     *  用于自定义错误
     * @param code
     * @param msg
     * @return
     */
    public static ServiceError displayError(String code,String msg){
        ServiceError error = ServiceError.DISPLAY_ERROR;
        error.setCode(code);
        error.setMsg(msg);
        return error;
    }

    @Override
    public String getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }

    ServiceError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

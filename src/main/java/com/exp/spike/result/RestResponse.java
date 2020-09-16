package com.exp.spike.result;

import com.exp.spike.error.IError;
import lombok.Data;

/**
 * @ClassName: Result
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-08-25 21:35
 * @Version: 1.0
 **/
@Data
public class RestResponse<T> {

    private static final String SUCCESS_CODE = "00000000";
    private static final String SUCCESS_MSG = "success";

    private String code;
    private String msg;
    private T data;

    private RestResponse() {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    private RestResponse(T data) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }

    /**
     *  成功不含数据的返回
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success() {
        RestResponse restResponse = new RestResponse();
        return restResponse;
    }

    /**
     *  成功含数据的返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success(T data) {
        RestResponse restResponse = new RestResponse(data);
        return restResponse;
    }

    /**
     *  错误返回对应的错误信息
     * @param error
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> error(IError error) {
        RestResponse restResponse = new RestResponse();
        restResponse.code = error.getErrorCode();
        restResponse.msg = error.getErrorMsg();
        return restResponse;
    }

}

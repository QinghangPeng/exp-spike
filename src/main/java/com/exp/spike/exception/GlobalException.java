package com.exp.spike.exception;

import com.exp.spike.error.ServiceError;
import lombok.Data;

/**
 * @ClassName: GlobalException
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-16 22:55
 * @Version: 1.0
 **/
@Data
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = -5292376027267157548L;

    private ServiceError error;

    public GlobalException(ServiceError error) {
        super(error.toString());
        this.error = error;
    }
}

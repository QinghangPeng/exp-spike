package com.exp.spike.exception;

import com.exp.spike.error.ServiceError;
import com.exp.spike.result.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-16 22:18
 * @Version: 1.0
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  根据不同的异常,输出合理的异常信息
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public RestResponse exceptionHandler(HttpServletRequest request,Exception e) {
        log.error("there is something wrong:{}",e);
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
//            String message = errors.stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(";"));
            String message = errors.get(0).getDefaultMessage();
            return RestResponse.error(ServiceError.fillArgs(message));
        } else if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return RestResponse.error(ex.getError());
        } else {
            return RestResponse.error(ServiceError.UN_KNOW_NULL);
        }
    }

}

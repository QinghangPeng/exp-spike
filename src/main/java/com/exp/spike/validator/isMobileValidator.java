package com.exp.spike.validator;

import com.exp.spike.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @ClassName: isMobileValidator
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-11 00:39
 * @Version: 1.0
 **/
public class isMobileValidator implements ConstraintValidator<isMobile,String> {


    private boolean required = false;

    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isMobile(value);
        } else {
            if (StringUtils.isBlank(value)) {
                return true;
            } else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}

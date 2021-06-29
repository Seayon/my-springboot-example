package com.saeyon.sys.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeCheckValidator implements ConstraintValidator<AgeCheck, Object> {

    private int min;

    private int max;

    public void initialize(AgeCheck constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    /**
     * 这里实现自己的校验逻辑
     *
     * @param object                     被注接的变量的原始值
     * @param constraintValidatorContext 约束校验上下文
     * @return
     */
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object instanceof Integer) {
            Integer integer = (Integer) object;
            if (integer <= this.min || integer >= max) {
                //屏蔽掉默认的报错信息
                constraintValidatorContext.disableDefaultConstraintViolation();
                //添加自定义的报错信息
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("年龄限定在 %s 至 %s 岁之间", min, max)).addConstraintViolation();
                return false;
            }
        } else {
            return true;
        }
        return true;
    }

}

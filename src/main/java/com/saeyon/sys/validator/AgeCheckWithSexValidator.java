package com.saeyon.sys.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class AgeCheckWithSexValidator implements ConstraintValidator<AgeCheckWithSex, Object> {

    private String ageFieldName;

    private String sexFieldName;

    public void initialize(AgeCheckWithSex constraintAnnotation) {
        this.ageFieldName = constraintAnnotation.ageFiledName();
        this.sexFieldName = constraintAnnotation.sexFiledName();
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
        Field fieldAge = null;
        Field fieldSex = null;
        try {
            fieldAge = object.getClass().getDeclaredField(ageFieldName);
            fieldSex = object.getClass().getDeclaredField(sexFieldName);
            fieldSex.setAccessible(true);
            fieldAge.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            //屏蔽掉默认的报错信息
            constraintValidatorContext.disableDefaultConstraintViolation();
            //添加自定义的报错信息
            constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("在类 %s 中未找到需要校验的字段,请检查", object.getClass().getCanonicalName())).addConstraintViolation();
            return false;
        }
        if (fieldAge != null && fieldSex != null) {
            try {
                int age = fieldAge.getInt(object);
                String sex = (String) fieldSex.get(object);
                if ("男".equals(sex)) {
                    if (age < 22) {
                        //屏蔽掉默认的报错信息
                        constraintValidatorContext.disableDefaultConstraintViolation();
                        //添加自定义的报错信息
                        constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("男性年龄不得低于 22 岁")).addConstraintViolation();
                        return false;
                    }
                }
                if ("女".equals(sex)) {
                    if (age < 20) {
                        //屏蔽掉默认的报错信息
                        constraintValidatorContext.disableDefaultConstraintViolation();
                        //添加自定义的报错信息
                        constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("女性年龄不得低于 20 岁")).addConstraintViolation();
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}

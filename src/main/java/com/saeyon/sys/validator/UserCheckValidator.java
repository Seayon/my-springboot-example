package com.saeyon.sys.validator;

import com.saeyon.vo.UserVo;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.sys.validator
 * @Author: Saeyon
 * @Date: 2021/7/1 2:24 上午
 * @Version V1.0
 * @Description:
 */
public class UserCheckValidator implements ConstraintValidator<UserCheck, Object> {
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (!(object instanceof UserVo)) {
            return true;
        }
        UserVo userVo = (UserVo) object;
        if (userVo == null) {
            return true;
        }
        int age = userVo.getAge();
        if ("男".equals(userVo.getSex())) {
            if (age < 22) {
                //屏蔽掉默认的报错信息
                constraintValidatorContext.disableDefaultConstraintViolation();
                //添加自定义的报错信息
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("男性年龄不得低于 22 岁")).addConstraintViolation();
                return false;
            }
        }
        if ("女".equals(userVo.getSex())) {
            if (age < 20) {
                //屏蔽掉默认的报错信息
                constraintValidatorContext.disableDefaultConstraintViolation();
                //添加自定义的报错信息
                constraintValidatorContext.buildConstraintViolationWithTemplate(String.format("女性年龄不得低于 20 岁")).addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}

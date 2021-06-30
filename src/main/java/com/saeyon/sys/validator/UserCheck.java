package com.saeyon.sys.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UserCheckValidator.class})
@Target({ElementType.TYPE}) // 只能添加在类上
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCheck {

    String message() default "User 对象参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

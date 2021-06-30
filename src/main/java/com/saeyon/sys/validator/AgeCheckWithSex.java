package com.saeyon.sys.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {AgeCheckWithSexValidator.class})
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeCheckWithSex {

    String ageFiledName();

    String sexFiledName();

    String message() default "性别和年龄参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

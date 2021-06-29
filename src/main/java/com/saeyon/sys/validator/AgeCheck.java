package com.saeyon.sys.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {AgeCheckValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeCheck {

    int min() default 0;

    int max() default 100;

    String message() default "年龄参数不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

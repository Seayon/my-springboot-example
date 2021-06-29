package com.saeyon.vo;

import com.saeyon.sys.validator.AgeCheck;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.vo
 * @Date: 2021/6/27 8:10 下午
 * @Version V1.0
 * @Description:
 */

@Getter
@Setter
public class UserVo {

    @NotBlank
    @AgeCheck
    private String name;

    @AgeCheck(min = 16, max = 120)
    private int age;

    @Pattern(regexp = "女|男", message = "性别只能是男或女")
    private String sex;

}

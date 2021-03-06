package com.saeyon.vo;

import com.saeyon.sys.validator.AgeCheck;
import com.saeyon.sys.validator.AgeCheckWithSex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@AgeCheckWithSex(ageFiledName = "age", sexFiledName = "sex", groups = {VisitorVo.Add.class})
public class VisitorVo {

    // 查询类分组
    public interface Query {

    }

    // 添加类分组
    public interface Add {

    }

    // 目的参观地址
    @NotBlank(message = "参观地址必须填写", groups = {Add.class})
    @NotNull
    private String address;

    // 参观者的年龄限制 18 岁以上 75 岁以下
    @AgeCheck(min = 18, max = 75)
    private int age;

    @Pattern(regexp = "女|男", message = "性别只能是男或女", groups = {Add.class, Query.class})
    private String sex;

    // 参观者的昵称
    @NotBlank(message = "参观者昵称必须填写", groups = {Add.class})
    private String nickName;

}

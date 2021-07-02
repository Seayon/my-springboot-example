package com.saeyon.vo;

import com.saeyon.sys.validator.AgeCheck;
import com.saeyon.sys.validator.PermGroupSequenceProvider;
import com.saeyon.sys.validator.UserCheck;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.vo
 * @Date: 2021/6/27 8:10 下午
 * @Version V1.0
 * @Description:
 */

@Getter
@Setter
@UserCheck
@GroupSequenceProvider(PermGroupSequenceProvider.class)
public class UserVo {

    @NotBlank(groups = {PermGroupSequenceProvider.Manager.class})
    @AgeCheck
    private String name;

    @AgeCheck(min = 16, max = 120, groups = {PermGroupSequenceProvider.Employee.class, Default.class})
    private int age;

    @Pattern(regexp = "女|男", message = "性别只能是男或女", groups = {PermGroupSequenceProvider.Manager.class})
    private String sex;

}

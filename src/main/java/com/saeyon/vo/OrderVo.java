package com.saeyon.vo;

import com.saeyon.sys.validator.UserCheck;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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
public class OrderVo {

    @NotNull(message = "ID 不能为空")
    private Long id;

    private String name;

    private BigDecimal price;

    @NotNull(message = "总数量不能为空")
    private BigDecimal count;

    @NotNull(message = "用户对象不能为空")
    @Valid
    UserVo user;
}

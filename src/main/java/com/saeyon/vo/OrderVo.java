package com.saeyon.vo;

import com.saeyon.sys.validator.AgeCheck;
import com.saeyon.sys.validator.UserCheck;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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

    private Long id;

    private String name;

    private BigDecimal price;

    private BigDecimal count;

}

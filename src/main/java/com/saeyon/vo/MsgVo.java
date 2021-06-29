package com.saeyon.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.vo
 * @Date: 2021/6/27 8:16 下午
 * @Version V1.0
 * @Description:
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MsgVo {

    public static final MsgVo SUCCESS = new MsgVo("处理成功", 0);

    public static final MsgVo FAIL = new MsgVo("处理失败", -9);

    private String msg;

    private int code;

}

package com.saeyon.controller;

import com.saeyon.sys.validator.PermGroupSequenceProvider;
import com.saeyon.vo.MsgVo;
import com.saeyon.vo.OrderVo;
import com.saeyon.vo.UserVo;
import com.saeyon.vo.VisitorVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.controller
 * @Author: SeayonZhao
 * @Date: 2021/6/27 6:43 下午
 * @Version V1.0
 * @Description:
 */
@Controller
@Log4j2
@Validated
public class ValidatorTestController {

    /**
     * @param name
     * @param age
     */
    @RequestMapping("/simple_param")
    public @ResponseBody
    MsgVo testParam(@Validated @NotNull String name, @Max(160) @NotNull @Valid Integer age) {
        return MsgVo.SUCCESS;
    }

    /**
     * @param name
     */
    @GetMapping("/validate_by_manual")
    public void validateByManual(@RequestParam String name) {
        if (name == null || name.length() <= 0) {
            // 抛出异常或返回报错等
            throw new RuntimeException("参数 姓名 不能为空");
        }
    }


    /**
     * @param userVo 接受参数的对象
     * @param errors 校验失败的结果
     */
    @PostMapping("/simple_param_with_body")
    public @ResponseBody
    MsgVo testWithBody(@RequestBody @Validated({PermGroupSequenceProvider.Manager.class}) UserVo userVo, Errors errors) {
        if (errors.hasErrors()) {
            StringBuilder errMsg = new StringBuilder();
            errors.getAllErrors().forEach(objectError -> {
                errMsg.append(objectError.getDefaultMessage() + " ");
            });
            return new MsgVo("入参数据不正确:" + errMsg.toString(), -1);
        }
        return MsgVo.SUCCESS;
    }

    @PostMapping("/addOrder")
    public @ResponseBody
    MsgVo addOrder(@RequestBody @Valid OrderVo orderVo) {
        return MsgVo.SUCCESS;
    }

    @PostMapping("/addVisitor")
    public @ResponseBody
    MsgVo addVisitor(@RequestBody @Validated({VisitorVo.Add.class, Default.class}) VisitorVo visitorVo) {
        return MsgVo.SUCCESS;
    }

    @PostMapping("/queryVisitor")
    public @ResponseBody
    MsgVo queryVisitor(@RequestBody @Validated({VisitorVo.Query.class}) VisitorVo visitorVo) {
        return MsgVo.SUCCESS;
    }


}

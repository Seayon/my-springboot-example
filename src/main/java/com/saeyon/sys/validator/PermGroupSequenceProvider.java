package com.saeyon.sys.validator;

import com.saeyon.vo.UserVo;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import org.springframework.context.annotation.Configuration;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongProjecet my-springboot-example
 * @BelongPackage com.saeyon.sys.validator
 * @Copyright 2018-2021 万达信息股份有限公司 - 医疗保障业务群
 * @Author: 赵旭阳/Zhao Xuyang
 * @Date: 2021/7/1 5:38 上午
 * @Version V1.0
 * @Description:
 */

@Configuration
public class PermGroupSequenceProvider implements DefaultGroupSequenceProvider<Object> {
    private String perm = "manager";

    public interface Manager {
    }

    public interface Employee {
    }

    @Override
    public List<Class<?>> getValidationGroups(Object userVo) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(UserVo.class);
        if (userVo != null) {
            if (perm.equals("manager")) {
                defaultGroupSequence.add(Manager.class);
            }
            if (perm.equals("employee")) {
                defaultGroupSequence.add(Employee.class);
            }
        }

        return defaultGroupSequence;
    }
}

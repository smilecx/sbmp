package com.ziyun.cloud.module.operator.vo;

import com.ziyun.cloud.module.operator.entity.Operator;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author:chenxiaoshuang
 * @Date:2019/2/1 16:00
 */
@Getter
@Setter
public class OperatorVo extends Operator {

    private Integer page;
    private Integer limit;

}

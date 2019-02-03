package com.ziyun.cloud.module.operator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ziyun.cloud.module.operator.entity.Operator;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenxiaoshuang
 * @since 2019-02-01
 */
public interface IOperatorService extends IService<Operator> {

    //根据用户名和密码查询到登录的用户
    Operator getOperatorByIdAndPwd(OperatorVo operatorVo);

    Page<OperatorVo> loadAllOperator(@NotNull @RequestBody OperatorVo operatorVo);

    //得到所有的操作员
}

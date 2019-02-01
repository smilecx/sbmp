package com.ziyun.cloud.module.operator.service;

import com.ziyun.cloud.module.operator.entity.Operator;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ziyun.cloud.module.operator.vo.OperatorVo;

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
}

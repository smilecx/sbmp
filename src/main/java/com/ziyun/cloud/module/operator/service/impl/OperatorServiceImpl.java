package com.ziyun.cloud.module.operator.service.impl;

import com.ziyun.cloud.module.operator.entity.Operator;
import com.ziyun.cloud.module.operator.mapper.OperatorMapper;
import com.ziyun.cloud.module.operator.service.IOperatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxiaoshuang
 * @since 2019-02-01
 */
@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements IOperatorService {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public Operator getOperatorByIdAndPwd(OperatorVo operatorVo) {
        return this.operatorMapper.queryOperatorByIdAndPwd(operatorVo);
    }
}

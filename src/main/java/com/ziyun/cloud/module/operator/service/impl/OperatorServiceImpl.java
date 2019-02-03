package com.ziyun.cloud.module.operator.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziyun.cloud.module.operator.entity.Operator;
import com.ziyun.cloud.module.operator.mapper.OperatorMapper;
import com.ziyun.cloud.module.operator.service.IOperatorService;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

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


    @Override
    public Operator getOperatorByIdAndPwd(OperatorVo operatorVo) {
        return this.baseMapper.queryOperatorByIdAndPwd(operatorVo);
    }

    @Override
    public Page<OperatorVo> loadAllOperator(@NotNull OperatorVo operatorVo) {
        Page<OperatorVo> page = new Page<>(operatorVo.getPage(),operatorVo.getLimit());
        List<OperatorVo> operatorVos = this.baseMapper.queryAllOperator(operatorVo, page);
        System.out.println(operatorVos);
        page.setRecords(operatorVos);
        return page;

    }

}

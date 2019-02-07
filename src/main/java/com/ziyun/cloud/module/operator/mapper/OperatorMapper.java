package com.ziyun.cloud.module.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ziyun.cloud.module.operator.entity.Operator;
import com.ziyun.cloud.module.operator.vo.OperatorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenxiaoshuang
 * @since 2019-02-01
 */
@Mapper
public interface OperatorMapper extends BaseMapper<Operator> {

    //根据用户名和密码查询登录用户
    Operator queryOperatorByIdAndPwd(@Param("operator") Operator operator);

    //queryAllOperator 查询所有的操作员
    List<OperatorVo> queryAllOperator(@Param("operator")Operator operator, @Param("page")Page<OperatorVo> page);
}

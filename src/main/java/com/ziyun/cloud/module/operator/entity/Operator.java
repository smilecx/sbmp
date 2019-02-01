package com.ziyun.cloud.module.operator.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiaoshuang
 * @since 2019-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;

    private String operatorId;

    private String operatorName;

    private String operatorPwd;

    private String adminType;


}

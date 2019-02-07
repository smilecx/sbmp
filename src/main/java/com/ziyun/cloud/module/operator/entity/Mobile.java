package com.ziyun.cloud.module.operator.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiaoshuang
 * @since 2019-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Mobile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mobileNumber;

    private String mobileType;

    private String cardNumber;

    private String available;


}

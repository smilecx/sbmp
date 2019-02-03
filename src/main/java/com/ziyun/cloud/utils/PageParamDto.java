package com.ziyun.cloud.utils;

import com.ziyun.cloud.constant.ErrorMessage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 页面参数
 * 
 * @author wang.jie
 * @date 2017年9月27日下午3:47:45
 */
@SuppressWarnings("serial")
@ApiModel
@Getter
@Setter
public class PageParamDto extends AbstractParamDto {

	@ApiModelProperty(value = " 获取当前页码")
	@Min(value = 1, message = ErrorMessage.COMMON_PAGE_ERROR)
	private Integer pageNo = 1;

	@ApiModelProperty(value = "获取每页显示数量")
	@Min(value = 1, message = ErrorMessage.COMMON_PAGE_ERROR)
	@Max(value = 50, message = ErrorMessage.COMMON_PAGE_ERROR)
	private Integer pageSize = 10;

	/**
	 * 
	 * @Description: 无页数默认第一页
	 * @title: setPageNo
	 * @author: shijy
	 * @date: 2018年9月28日
	 * @param pageNo
	 * @return: void
	 */
	public void setPageNo(Integer pageNo) {
		if (pageNo == null) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}

	}

	/**
	 *
	 * @Description: 限制最多一次只能查询50条数据
	 * @title: setPageSize
	 * @author: shijy
	 * @date: 2018年9月28日
	 * @param pageSize
	 * @return: void
	 */
	public void setPageSize(Integer pageSize) {
		if (pageSize == null || pageSize > 50) {
			this.pageSize = 50;
		} else {
			this.pageSize = pageSize;
		}

	}

}

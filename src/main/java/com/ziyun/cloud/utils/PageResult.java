package com.ziyun.cloud.utils;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 分页消息
 * 
 * @author wang.jie
 * @date 2018年9月28日 上午9:00:32
 * @param <T>
 */
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 当前页记录 */
	@ApiModelProperty(value = "当前页记录")
	private List<T> records;

	/** 总行数 */
	@ApiModelProperty(value = "总行数")
	private Integer total;

	/** 总页数 */
	@ApiModelProperty(value = "总页数")
	private Integer totalPage;

	/** 当前页 */
	@ApiModelProperty(value = "当前页")
	private Integer current;

	/** 每页数量 */
	@ApiModelProperty(value = "每页数量")
	private Integer size;

	public PageResult() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static PageResult<?> valueOf(List<?> records, Integer total, Integer totalPage, Integer current,
			Integer size) {
		PageResult<?> result = new PageResult(records, total, totalPage, current, size);
		return result;

	}

	public PageResult(List<T> records, Integer total, Integer totalPage, Integer current, Integer size) {
		this.records = records;
		this.total = total;
		this.current = current;
		this.size = size;
		this.totalPage = totalPage;

	}

	public PageResult(List<T> records, Long total, Long current, Long size) {
		this.records = records;
		this.total = total.intValue();
		this.current = current.intValue();
		this.size = size.intValue();
		this.totalPage = total.intValue() / size.intValue();
		if (total.intValue() % size.intValue() != 0) {
			this.totalPage++;
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static PageResult<?> valueOf(List<?> records, Long total, Long current, Long size) {
		PageResult<?> result = new PageResult(records, total, current, size);
		return result;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalPage() {
		if (this.totalPage == null && this.total != null && this.size != null) {
			this.totalPage = this.total.intValue() / this.size.intValue();
			if (this.total.intValue() % this.size.intValue() != 0) {
				this.totalPage++;
			}
		}
		return this.totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}

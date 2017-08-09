package com.sys.web.controller.util;

/**
 * 分页模板
 * @author sunlibao
 *
 */
public class PageModel{

	/**
	 * 当前页
	 */
	private Integer currentPage;
	/**
	 * 每页显示条数
	 */
	private Integer pageSize;
	
	/**
	 * 总条数
	 */
	private Integer totalCount;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 数据集合
	 */
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	


}

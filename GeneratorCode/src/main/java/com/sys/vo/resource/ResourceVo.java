package com.sys.vo.resource;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Generated;

/**
 * 资源Vo
 * @author sunlibao
 *
 */
public class ResourceVo {
	

	/** 主键id  */
	private  Long id;
	
	/** 父级菜单id  */
	private  Long pId;
	
	/** 菜单名称  */
	private  String name;
	
	/** 菜单编号  */
	private  String code;
	
	/** 排序字段  */
	private  Integer sort;
	
	/** 资源类型  1-菜单  2-按钮  */
	private  Integer type;
	
	/** 操作请求地址  */
	private  String url;
	
	/** 添加时间  */
	private  Timestamp ctime = new Timestamp(System.currentTimeMillis());
	
	/** 修改时间  */
	private  Timestamp utime;
	
	/** 删除标记 0-未删除 1-删除  */
	private  boolean dr = false;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Timestamp getUtime() {
		return utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public boolean isDr() {
		return dr;
	}

	public void setDr(boolean dr) {
		this.dr = dr;
	}
	
	
	
	
	
	

}

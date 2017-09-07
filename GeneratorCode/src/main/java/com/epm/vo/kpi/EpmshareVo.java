package com.epm.vo.kpi;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EpmshareVo {

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String dpostion;

	private String flag;

	private BigInteger kpiid;

	private String mark;

	private String name;

	private String positioncode;

	private int type;

	private String username;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDpostion() {
		return this.dpostion;
	}

	public void setDpostion(String dpostion) {
		this.dpostion = dpostion;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public BigInteger getKpiid() {
		return this.kpiid;
	}

	public void setKpiid(BigInteger kpiid) {
		this.kpiid = kpiid;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPositioncode() {
		return this.positioncode;
	}

	public void setPositioncode(String positioncode) {
		this.positioncode = positioncode;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}

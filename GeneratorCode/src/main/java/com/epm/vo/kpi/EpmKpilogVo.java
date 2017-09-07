package com.epm.vo.kpi;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 雇员kpi
 * @author sunlibao
 *
 */
@MappedSuperclass
public class EpmKpilogVo {
	
	@Id
	private String id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String efunction;

	private BigInteger epmid;

	private BigInteger kpiid;

	private String modifyusername;

	private String resource;

	private String target;

	private int taux;

	private String title;

	private String type;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getEfunction() {
		return this.efunction;
	}

	public void setEfunction(String efunction) {
		this.efunction = efunction;
	}

	public BigInteger getEpmid() {
		return this.epmid;
	}

	public void setEpmid(BigInteger epmid) {
		this.epmid = epmid;
	}

	public BigInteger getKpiid() {
		return this.kpiid;
	}

	public void setKpiid(BigInteger kpiid) {
		this.kpiid = kpiid;
	}

	public String getModifyusername() {
		return this.modifyusername;
	}

	public void setModifyusername(String modifyusername) {
		this.modifyusername = modifyusername;
	}

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getTaux() {
		return this.taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

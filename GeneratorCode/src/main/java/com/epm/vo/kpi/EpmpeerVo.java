package com.epm.vo.kpi;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EpmpeerVo {

	@Id
	private String id;

	private String company;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String createuserename;

	private String departmentname;

	private String dpostion;

	private BigInteger epmid;

	@Lob
	private String evalueted;

	private String flag;

	private String mark;

	private String niveau;

	private String peersname;

	private String peersusername;

	private String positioncode;

	private String stauts;

	private int type;

	private double weights;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateuserename() {
		return this.createuserename;
	}

	public void setCreateuserename(String createuserename) {
		this.createuserename = createuserename;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDpostion() {
		return this.dpostion;
	}

	public void setDpostion(String dpostion) {
		this.dpostion = dpostion;
	}

	public BigInteger getEpmid() {
		return this.epmid;
	}

	public void setEpmid(BigInteger epmid) {
		this.epmid = epmid;
	}

	public String getEvalueted() {
		return this.evalueted;
	}

	public void setEvalueted(String evalueted) {
		this.evalueted = evalueted;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getPeersname() {
		return this.peersname;
	}

	public void setPeersname(String peersname) {
		this.peersname = peersname;
	}

	public String getPeersusername() {
		return this.peersusername;
	}

	public void setPeersusername(String peersusername) {
		this.peersusername = peersusername;
	}

	public String getPositioncode() {
		return this.positioncode;
	}

	public void setPositioncode(String positioncode) {
		this.positioncode = positioncode;
	}

	public String getStauts() {
		return this.stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getWeights() {
		return this.weights;
	}

	public void setWeights(double weights) {
		this.weights = weights;
	}
	
}

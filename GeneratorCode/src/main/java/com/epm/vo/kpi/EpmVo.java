package com.epm.vo.kpi;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
public class EpmVo {
	
	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date edate;

	private String edepartcode;

	private String edepartmentname;

	private String edpostion;

	private String eevaluate;

	private String ename;

	private String epositioncode;

	private String eusername;

	@Lob
	private String evalueted;

	private int flag;

	private int kpistatus;

	private String mainposition;

	private String mark;

	private String mdepartcode;

	private String mdepartmentname;

	private String mdposition;

	private BigInteger meid;

	@Lob
	private String mevalueted;

	private String mname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifytime;

	@Lob
	private String mpip;

	private String mpositioncode;

	private String mstaffcode;

	private String museranme;

	private String niveau;

	private int peersstatus;

	@Lob
	private String pip;

	private String rentong;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sdate;

	private String staffcode;

	private int status;

	private int type;

	private double weights;

	private double weights1;

	private double weights2;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getEdepartcode() {
		return this.edepartcode;
	}

	public void setEdepartcode(String edepartcode) {
		this.edepartcode = edepartcode;
	}

	public String getEdepartmentname() {
		return this.edepartmentname;
	}

	public void setEdepartmentname(String edepartmentname) {
		this.edepartmentname = edepartmentname;
	}

	public String getEdpostion() {
		return this.edpostion;
	}

	public void setEdpostion(String edpostion) {
		this.edpostion = edpostion;
	}

	public String getEevaluate() {
		return this.eevaluate;
	}

	public void setEevaluate(String eevaluate) {
		this.eevaluate = eevaluate;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpositioncode() {
		return this.epositioncode;
	}

	public void setEpositioncode(String epositioncode) {
		this.epositioncode = epositioncode;
	}

	public String getEusername() {
		return this.eusername;
	}

	public void setEusername(String eusername) {
		this.eusername = eusername;
	}

	public String getEvalueted() {
		return this.evalueted;
	}

	public void setEvalueted(String evalueted) {
		this.evalueted = evalueted;
	}

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getKpistatus() {
		return this.kpistatus;
	}

	public void setKpistatus(int kpistatus) {
		this.kpistatus = kpistatus;
	}

	public String getMainposition() {
		return this.mainposition;
	}

	public void setMainposition(String mainposition) {
		this.mainposition = mainposition;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMdepartcode() {
		return this.mdepartcode;
	}

	public void setMdepartcode(String mdepartcode) {
		this.mdepartcode = mdepartcode;
	}

	public String getMdepartmentname() {
		return this.mdepartmentname;
	}

	public void setMdepartmentname(String mdepartmentname) {
		this.mdepartmentname = mdepartmentname;
	}

	public String getMdposition() {
		return this.mdposition;
	}

	public void setMdposition(String mdposition) {
		this.mdposition = mdposition;
	}

	public BigInteger getMeid() {
		return this.meid;
	}

	public void setMeid(BigInteger meid) {
		this.meid = meid;
	}

	public String getMevalueted() {
		return this.mevalueted;
	}

	public void setMevalueted(String mevalueted) {
		this.mevalueted = mevalueted;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getMpip() {
		return this.mpip;
	}

	public void setMpip(String mpip) {
		this.mpip = mpip;
	}

	public String getMpositioncode() {
		return this.mpositioncode;
	}

	public void setMpositioncode(String mpositioncode) {
		this.mpositioncode = mpositioncode;
	}

	public String getMstaffcode() {
		return this.mstaffcode;
	}

	public void setMstaffcode(String mstaffcode) {
		this.mstaffcode = mstaffcode;
	}

	public String getMuseranme() {
		return this.museranme;
	}

	public void setMuseranme(String museranme) {
		this.museranme = museranme;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getPeersstatus() {
		return this.peersstatus;
	}

	public void setPeersstatus(int peersstatus) {
		this.peersstatus = peersstatus;
	}

	public String getPip() {
		return this.pip;
	}

	public void setPip(String pip) {
		this.pip = pip;
	}

	public String getRentong() {
		return this.rentong;
	}

	public void setRentong(String rentong) {
		this.rentong = rentong;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public String getStaffcode() {
		return this.staffcode;
	}

	public void setStaffcode(String staffcode) {
		this.staffcode = staffcode;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public double getWeights1() {
		return this.weights1;
	}

	public void setWeights1(double weights1) {
		this.weights1 = weights1;
	}

	public double getWeights2() {
		return this.weights2;
	}

	public void setWeights2(double weights2) {
		this.weights2 = weights2;
	}

}

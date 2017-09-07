package com.epm.vo.kpi;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class EpmKpiVo {

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	/**
	 * 创建人
	 */
	private String createuser;

	@Lob
	private String efunction;

	/**
	 * 绩效id
	 */
	private BigInteger epmid;

	/**
	 * 员工自评
	 */
	@Lob
	private String evaluate;

	/**
	 * 岗位段
	 */
	private int flag;

	/**
	 * 是否邀请打分 0未邀请 1邀请
	 */
	private String flagkpi;

	/**
	 * 重要性
	 */
	private String imprtance;

	/**
	 * 备注
	 */
	private String mark;

	/**
	 * 经理评价
	 */
	@Lob
	private String mevaluate;

	/**
	 * 等级
	 */
	private String niveau;

	/**
	 * 紧急性
	 */
	private String priority;

	/**
	 * 绩效评测数据来源
	 */
	private String resource;

	/**
	 * 打分值
	 */
	private float score;

	/**
	 * kpi 目标
	 */
	private String target;

	/**
	 * 绩效任务内容
	 */
	@Lob
	private String taskname;

	/**
	 * 绩效结果
	 */
	private String taskresult;

	/**
	 * 占百分比
	 */
	private int taux;

	/**
	 * kpi标题
	 */
	private String title;

	/**
	 * 百分比对应分值
	 */
	private float weighting;

	/**
	 * 年份
	 */
	private byte year;


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return this.createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
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

	public String getEvaluate() {
		return this.evaluate;
	}

	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}

	public int getFlag() {
		return this.flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getFlagkpi() {
		return this.flagkpi;
	}

	public void setFlagkpi(String flagkpi) {
		this.flagkpi = flagkpi;
	}

	public String getImprtance() {
		return this.imprtance;
	}

	public void setImprtance(String imprtance) {
		this.imprtance = imprtance;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMevaluate() {
		return this.mevaluate;
	}

	public void setMevaluate(String mevaluate) {
		this.mevaluate = mevaluate;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskresult() {
		return this.taskresult;
	}

	public void setTaskresult(String taskresult) {
		this.taskresult = taskresult;
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

	public float getWeighting() {
		return this.weighting;
	}

	public void setWeighting(float weighting) {
		this.weighting = weighting;
	}

	public byte getYear() {
		return this.year;
	}

	public void setYear(byte year) {
		this.year = year;
	}

}

package com.epm.entity.kpi;

import java.io.Serializable;

import javax.persistence.*;

import com.epm.vo.kpi.EpmKpilogVo;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the epm_kpilog database table.
 * 
 */
@Entity
@Table(name="epm_kpilog")
@NamedQuery(name="EpmKpilog.findAll", query="SELECT e FROM EpmKpilog e")
public class EpmKpilogEntity extends EpmKpilogVo implements Serializable {
	private static final long serialVersionUID = 1L;

	

}
package com.epm.entity.kpi;

import java.io.Serializable;

import javax.persistence.*;

import com.epm.vo.kpi.EpmKpiVo;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the epm_kpis database table.
 * 
 */
@Entity
@Table(name="epm_kpis")
@NamedQuery(name="EpmKpi.findAll", query="SELECT e FROM EpmKpi e")
public class EpmKpiEntity extends EpmKpiVo implements Serializable  {
	private static final long serialVersionUID = 1L;

	

}
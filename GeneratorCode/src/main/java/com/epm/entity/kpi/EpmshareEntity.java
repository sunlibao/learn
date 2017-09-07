package com.epm.entity.kpi;

import java.io.Serializable;

import javax.persistence.*;

import com.epm.vo.kpi.EpmshareVo;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the epmshare database table.
 * 
 */
@Entity
@NamedQuery(name="Epmshare.findAll", query="SELECT e FROM Epmshare e")
public class EpmshareEntity extends EpmshareVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
}
package com.epm.entity.kpi;

import java.io.Serializable;

import javax.persistence.*;

import com.epm.vo.kpi.EpmVo;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the epm database table.
 * 
 */
@Entity
@NamedQuery(name="Epm.findAll", query="SELECT e FROM Epm e")
public class EpmEntity extends EpmVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
}
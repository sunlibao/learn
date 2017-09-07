package com.epm.entity.kpi;

import java.io.Serializable;

import javax.persistence.*;

import com.epm.vo.kpi.EpmpeerVo;

import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the epmpeers database table.
 * 
 */
@Entity
@Table(name="epmpeers")
@NamedQuery(name="Epmpeer.findAll", query="SELECT e FROM Epmpeer e")
public class EpmpeerEntity extends EpmpeerVo implements Serializable {
	private static final long serialVersionUID = 1L;

	

}
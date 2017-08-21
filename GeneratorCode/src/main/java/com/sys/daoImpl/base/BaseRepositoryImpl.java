package com.sys.daoImpl.base;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.sys.dao.base.BaseRepository;

public class BaseRepositoryImpl <T> extends SimpleJpaRepository<T, Long> implements BaseRepository<T> {

	
	private final Class<T> domainClass;
	
	
	public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.domainClass = domainClass;
	}
	
	
	
	
	
}

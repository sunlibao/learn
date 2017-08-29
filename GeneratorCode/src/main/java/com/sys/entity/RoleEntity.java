package com.sys.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.sys.entity.resource.ResourceEntity;
import com.sys.vo.role.RoleVo;


@Entity
@Table(name="basic_role")
public class RoleEntity extends RoleVo{
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="basic_permission",joinColumns={@JoinColumn(name="roleId")},
	inverseJoinColumns={@JoinColumn(name="resId")})
	private Set<ResourceEntity> resourceSet = new HashSet<ResourceEntity>();

	
	public Set<ResourceEntity> getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(Set<ResourceEntity> resourceSet) {
		this.resourceSet = resourceSet;
	}
	
	
	

}

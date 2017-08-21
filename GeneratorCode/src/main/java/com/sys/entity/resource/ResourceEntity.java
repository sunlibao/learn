package com.sys.entity.resource;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sys.vo.resource.ResourceVo;

/**
 * 资源entity
 * @author sunlibao
 *
 */
@Entity
@Table(name="basic_resource")
public class ResourceEntity extends ResourceVo {

}

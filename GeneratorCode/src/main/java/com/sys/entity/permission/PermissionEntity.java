package com.sys.entity.permission;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sys.vo.pemission.PermissionVo;

/**
 * 权限类实体
 * @author sunlibao
 *
 */
@Entity
@Table(name="basic_permission")
public class PermissionEntity extends PermissionVo {

}

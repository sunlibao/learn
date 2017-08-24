package com.sys.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sys.vo.user.UserVo;

@Entity
@Table(name="basic_user")
public class UserEntity extends UserVo  {

}

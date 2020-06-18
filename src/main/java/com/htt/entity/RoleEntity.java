package com.htt.entity;

import com.htt.anotatiton.Column;
import com.htt.anotatiton.Table;

@Table("role")
public class RoleEntity extends CommonEntity {
	@Column("code")
	private String code;
	@Column("name")
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

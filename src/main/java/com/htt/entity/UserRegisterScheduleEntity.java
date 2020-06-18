package com.htt.entity;

import java.sql.Timestamp;

import com.htt.anotatiton.Column;
import com.htt.anotatiton.Table;

@Table("user_register_schedule")
public class UserRegisterScheduleEntity extends CommonEntity{
	@Column("user_id")
	private String userId;
	@Column("deadline_id")
	private String deadlineId;
	@Column("week_in_year")
	
	
	
	
	
	
	
	
	
	
	
	private String isRegister;
	@Column("phone_number")
	private String phoneNumber;
	@Column("address")
	private String address;
	@Column("dob")
	private Timestamp dob;
	@Column("university")
	private String university;
	@Column("role_id")
	private Integer roleId;

}

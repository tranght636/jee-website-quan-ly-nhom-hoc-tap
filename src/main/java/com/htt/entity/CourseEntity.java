package com.htt.entity;

import java.sql.Timestamp;

import com.htt.anotatiton.Column;
import com.htt.anotatiton.Table;

@Table("courses")
public class CourseEntity extends CommonEntity{
	@Column("name")
	private String name;
	@Column("start_time")
	private Timestamp startTime;
	@Column("end_time")
	private Timestamp endTime;
	@Column("description")
	private String description;
	@Column("note")
	private String note;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}

package com.htt.entity;

import java.sql.Timestamp;

import com.htt.anotatiton.Column;
import com.htt.anotatiton.Table;
@Table("deadline")
public class DeadlineEntity {
	@Column("title")
	private String title;
	@Column("content")
	private String content;
	@Column("to_classes")
	private String toClass;
	@Column("due_date")
	private Timestamp dueDate;
	@Column("is_register")
	private Boolean isRegister;
	@Column("due_week")
	private String dueWeek;
	
	private int status;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getToClass() {
		return toClass;
	}
	public void setToClass(String toClass) {
		this.toClass = toClass;
	}
	public Timestamp getDueDate() {
		return dueDate;
	}
	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}
	
	public Boolean getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister = isRegister;
	}
	public String getDueWeek() {
		return dueWeek;
	}
	public void setDueWeek(String dueWeek) {
		this.dueWeek = dueWeek;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}

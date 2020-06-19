package com.htt.model;

import java.sql.Timestamp;

public class DeadlineModel extends AbstractModel<DeadlineModel> {
	private String title;
	private String content;
	private String toClass;
	private Timestamp dueDate;
	private Boolean isRegister;
	private String weekInYear;
	//private int year;
	//private int week;
	
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
	public String getWeekInYear() {
		return weekInYear;
	}
	public void setWeekInYear(String WeekInYear) {
		this.weekInYear = WeekInYear;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

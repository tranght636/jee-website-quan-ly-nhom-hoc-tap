package com.htt.model;

public class ThongBaoModel extends AbstractModel<ThongBaoModel>  {
	private String title;
	private String content;
	private String toClass;
	private int status;
	public String getToClass() {
		return toClass;
	}
	public void setToClass(String toClass) {
		this.toClass = toClass;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
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

}

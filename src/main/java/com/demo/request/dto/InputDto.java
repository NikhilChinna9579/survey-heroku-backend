package com.demo.request.dto;

public class InputDto {
	
	private String userName;
	private String password;
	private FeedbackForm saveFeedbackForm;
	
	public FeedbackForm getSaveFeedbackForm() {
		return saveFeedbackForm;
	}
	public void setSaveFeedbackForm(FeedbackForm saveFeedbackForm) {
		this.saveFeedbackForm = saveFeedbackForm;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

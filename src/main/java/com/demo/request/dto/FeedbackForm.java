package com.demo.request.dto;

import java.util.List;

public class FeedbackForm {
	
	private String reviewerName;
	private String reviewerEmail;
	private String additonalComment;
	private List<QuestionAnswer> questionsAndAnswers;
	
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public String getReviewerEmail() {
		return reviewerEmail;
	}
	public void setReviewerEmail(String reviewerEmail) {
		this.reviewerEmail = reviewerEmail;
	}
	public String getAdditonalComment() {
		return additonalComment;
	}
	public void setAdditonalComment(String additonalComment) {
		this.additonalComment = additonalComment;
	}
	public List<QuestionAnswer> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}
	public void setQuestionsAndAnswers(List<QuestionAnswer> questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}
	

}

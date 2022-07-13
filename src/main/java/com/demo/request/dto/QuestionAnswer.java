package com.demo.request.dto;

public class QuestionAnswer {
	private Long questionId;
	private String questionDescription;
	private Long rating;

	public String getRatingtext() {
		return ratingtext;
	}

	public void setRatingtext(String ratingtext) {
		this.ratingtext = ratingtext;
	}

	private String ratingtext;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	
	

}

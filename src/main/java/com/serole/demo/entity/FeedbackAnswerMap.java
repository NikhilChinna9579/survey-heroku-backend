package com.serole.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FeedbackAnswerMap")
public class FeedbackAnswerMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedbackAnswerMapId")
	private Long feedbackAnswerMapId;
	
	@ManyToOne
	@JoinColumn(name = "feedbackId")
	private Feedback  feedback;
	
	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question  question;
	
	@Column(name = "rating")
	private Long  rating;

	public Long getFeedbackAnswerMapId() {
		return feedbackAnswerMapId;
	}

	public void setFeedbackAnswerMapId(Long feedbackAnswerMapId) {
		this.feedbackAnswerMapId = feedbackAnswerMapId;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}



}

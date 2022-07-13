package com.serole.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedbackId")
	private Long feedbackId;
	
	@Column(name = "reviewerName")
	private String reviewerName;
	
	@Column(name = "reviewerEmail")
	private String reviewerEmail;
	
	@Column(name = "additonalComment")
	private String additonalComment;

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

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
	
	
}

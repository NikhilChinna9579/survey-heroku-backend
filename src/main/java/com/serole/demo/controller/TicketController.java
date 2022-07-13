package com.serole.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.request.dto.FeedbackForm;
import com.demo.request.dto.InputDto;
import com.serole.demo.entity.Question;
import com.serole.demo.service.FeedbackService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping(value = "/getAllQuestions", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Question> getQuestions() {
		return (List<Question>) feedbackService.getQuestions();
	}

	@PostMapping(value = "/loginAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean loginAdmin(@RequestBody InputDto input) {
		return feedbackService.loginAdmin(input.getUserName(), input.getPassword());
	}

	@PostMapping(value = "/saveFeedback", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveFeedback(@RequestBody InputDto input) {
		return feedbackService.saveFeedback(input.getSaveFeedbackForm());
	}
	
	@GetMapping(value = "/getAllFeedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FeedbackForm> getAllFeedbacks() {
		return feedbackService.getAllFeedbacks();
	}

	/*
	 * @PostMapping(value = "/saveQuestion",produces =
	 * MediaType.APPLICATION_JSON_VALUE) public SurveyQuestion
	 * getQuestions(@RequestBody InputDto input){ return
	 * feedbackService.saveQuestions(input.getQuestion()); }
	 * 
	 * 
	 * @PostMapping(value = "/deleteQuestion",produces =
	 * MediaType.APPLICATION_JSON_VALUE) public String deleteQuestions(@RequestBody
	 * InputDto input){ return
	 * feedbackService.deleteQuestion(input.getQuestionId()); }
	 * 
	 */
}

package com.serole.demo.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.request.dto.QuestionAnswer;
import com.demo.request.dto.FeedbackForm;
import com.serole.demo.entity.Feedback;
import com.serole.demo.entity.FeedbackAnswerMap;
import com.serole.demo.entity.Question;
import com.serole.demo.repository.FeedbackAnswerMapRepository;
import com.serole.demo.repository.FeedbackRepository;
import com.serole.demo.repository.QuestionRepository;
import com.serole.demo.repository.UserRepository;

@Service
public class FeedbackService {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private FeedbackAnswerMapRepository feedbackAnswerMapRepository;
	

	
	

	public List<Question> getQuestions() {
		return (List<Question>) questionRepository.findAll();
	}
	
	public Boolean loginAdmin(String userName,String password ) {
		
		int count = userRepository.getUser(userName,password);
		if(count>0) {
			return true;
		}
		return false;
		
	}
	
	public String saveFeedback(FeedbackForm saveFeedbackForm) {
		
		Feedback feedback = new Feedback();
		feedback.setReviewerEmail(saveFeedbackForm.getReviewerEmail());
		feedback.setReviewerName(saveFeedbackForm.getReviewerName());
		feedback.setAdditonalComment(saveFeedbackForm.getAdditonalComment());
		Feedback feedbackdb = feedbackRepository.save(feedback);
		
		List<Question> allQuestions = (List<Question>) questionRepository.findAll();
		
		
		List<FeedbackAnswerMap> feedbackAnswerMapToSave = new ArrayList<>();
		for(QuestionAnswer questionAnswer: saveFeedbackForm.getQuestionsAndAnswers() ) {
			FeedbackAnswerMap feedbackAnswerMap = new FeedbackAnswerMap();
			feedbackAnswerMap.setFeedback(feedbackdb);
			
			Question question = allQuestions.stream().filter(x->x.getQuestionId().equals(questionAnswer.getQuestionId())).findAny().orElse(null);
			
			feedbackAnswerMap.setQuestion(question);
			feedbackAnswerMap.setRating(questionAnswer.getRating());
			feedbackAnswerMapToSave.add(feedbackAnswerMap);
		}
		feedbackAnswerMapRepository.saveAll(feedbackAnswerMapToSave);
		
		return "Thanks for Submitting the Feedback!";
		
	}
	
	
	public List<FeedbackForm> getAllFeedbacks() {
		Map<Integer,String> rmap=new HashMap<>();
		rmap.put(5,"Very Likely");
		rmap.put(4,"Good");
		rmap.put(3,"Very Likely");
		rmap.put(2,"Very Likely");
		rmap.put(1,"Very Likely");
		List<Feedback> allFeedbacks = feedbackRepository.getAllFeedback();
		List<FeedbackAnswerMap> allFeedbacksAnswers = (List<FeedbackAnswerMap>) feedbackAnswerMapRepository.findAll();

		List<FeedbackForm> response = new ArrayList<>();
		for (Feedback feedback : allFeedbacks) {
			FeedbackForm feedbackForm = new FeedbackForm();
			feedbackForm.setReviewerName(feedback.getReviewerName());
			feedbackForm.setReviewerEmail(feedback.getReviewerEmail());
			feedbackForm.setAdditonalComment(feedback.getAdditonalComment());
			List<FeedbackAnswerMap> feedbackAnswerMap1 = allFeedbacksAnswers.stream()
					.filter(x -> x.getFeedback().getFeedbackId().equals(feedback.getFeedbackId())).collect(Collectors.toList());

			feedbackForm.setQuestionsAndAnswers(feedbackAnswerMap1.stream().map(x -> {
				QuestionAnswer questionAnswer = new QuestionAnswer();
				questionAnswer.setQuestionId(x.getQuestion().getQuestionId());
				questionAnswer.setQuestionDescription(x.getQuestion().getQuestionDescription());
				questionAnswer.setRating(x.getRating());
				questionAnswer.setRatingtext(rmap.get(x.getRating()));
				return questionAnswer;
			}).collect(Collectors.toList()));
			response.add(feedbackForm);

		}
		return response;

	}
	
	
	/*
	 * 
	 * public String deleteQuestion(Long questionId){ Optional<SurveyQuestion> res =
	 * surveyQuestionRepository.findById(questionId); if(res.get()!=null) {
	 * surveyQuestionRepository.deleteById(questionId); return
	 * "Successfully Deleted"; }
	 * 
	 * return "Invalid Question";
	 * 
	 * }
	 */
}

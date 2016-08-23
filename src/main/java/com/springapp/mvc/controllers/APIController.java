package com.springapp.mvc.controllers;


import com.springapp.mvc.model.ContentWrapper;
import com.springapp.mvc.service.EmailService;
import com.springapp.mvc.service.QuestionsService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//this is a rest api that needs to accept json input which will have name, id of question, and the answer. Need
// to be able to verify if the applicant passes min qualifications or not.

@RestController
@RequestMapping("/")
public class APIController {

	@Autowired
	private UserService userService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ContentWrapper> consumeApplication(@RequestBody ContentWrapper wrapper) {
		int questionListSize = wrapper.getQuestions().size();
		int minQues = 0;
		for(int i = 0; i < questionListSize; i++){
			if(wrapper.getQuestions().get(i).getAnswer().equalsIgnoreCase("yes")){
				minQues += 1;
			}
		}
		if(minQues == questionListSize){
			userService.saveUser(wrapper.getUser());
//				for(int q = 0; q < wrapper.getQuestions().size(); q++){
//					questionsService.saveQuestions(wrapper.getQuestions().get(q));
//				}
			emailService.sendEmail(wrapper);
		}

		return new ResponseEntity<ContentWrapper>(wrapper, HttpStatus.CREATED);
	}

}
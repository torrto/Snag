package com.springapp.mvc.controllers;


import com.springapp.mvc.model.Questions;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.QuestionsService;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this is a rest api that needs to accept json input which will have name, id of question, and the answer. Need
// to be able to verify if the applicant passes min qualifications or not.

@RestController
@RequestMapping("/")
public class APIController {

	@Autowired
	private UserService userService;
	@Autowired
	private QuestionsService questionsService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void consumeApplication(@RequestBody User user, @RequestBody List<Questions> questions) {
		userService.saveUser(user);
		questionsService.saveQuestions(questions);
	}



//	@RequestMapping(method = RequestMethod.GET)
//	public String testHibernateGet(ModelMap model) {
//		return "testhibernateget";
//	}
//
//	@RequestMapping(value = "/testhibernate", method = RequestMethod.POST)
//	public String testHibernate(@ModelAttribute("user") User user) {
//		service.saveUser(user);
//		return "testhibernate";
//	}
}
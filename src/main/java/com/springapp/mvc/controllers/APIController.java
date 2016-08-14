package com.springapp.mvc.controllers;


import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//this is a rest api that needs to accept json input which will have name, id of question, and the answer. Need
// to be able to verify if the applicant passes min qualifications or not.

@RestController
@RequestMapping("/")
public class APIController {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void consumeApplication(@RequestBody User user) {
		service.saveUser(user);
	}
}
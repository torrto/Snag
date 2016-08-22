package com.springapp.mvc.controllers;


import com.springapp.mvc.model.ContentWrapper;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.EmailService;
import com.springapp.mvc.service.QuestionsService;
import com.springapp.mvc.service.QuestionsServiceImpl;
import com.springapp.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
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

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<ContentWrapper> consumeApplication(@RequestBody ContentWrapper wrapper) {
		System.out.println("hoping its not failing....... I hope" + wrapper.getUser().getUsername());
//		userService.saveUser(wrapper.getUser());
//		for(int i = 0; i < wrapper.getQuestions().size(); i++){
//			questionsService.saveQuestions(wrapper.getQuestions().get(i));
//		}
		System.out.println("saved I hope" + wrapper.getUser().getEmail());
		emailService.sendEmail(wrapper);






		return new ResponseEntity<ContentWrapper>(wrapper, HttpStatus.CREATED);
	}


//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//	public void consumeApplication(@RequestBody ContentWrapper content) {
//
//		boolean approval = true;
//
//		for(int i = 0; i < content.getQuestions().size(); i++){
//			questionsService = new QuestionsServiceImpl();
//			answer = questionsService.getAnswerById(content.getQuestions().get(i).getId());
//
//			if(!(content.getQuestions().get(i).getAnswer().equals(answer))) {
//				approval = false;
//			}
//		}
//		if(approval == true){
//			userService.saveUser(content.getUser());
//		}
//	}



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
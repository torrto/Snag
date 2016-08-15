package com.springapp.mvc.service;

import com.springapp.mvc.dao.QuestionsDao;
import com.springapp.mvc.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsDao dao;

    public void saveQuestions(List<Questions> questions) {
        dao.saveQuestions(questions);
    }
}

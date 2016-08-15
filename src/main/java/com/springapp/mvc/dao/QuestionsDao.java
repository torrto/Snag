package com.springapp.mvc.dao;

import com.springapp.mvc.model.Questions;

import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
public interface QuestionsDao {

    void saveQuestions (List<Questions> questions);

    Questions getQuestionbyId (int id);


}

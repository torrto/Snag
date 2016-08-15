package com.springapp.mvc.service;

import com.springapp.mvc.model.Questions;
import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
public interface QuestionsService {

    void saveQuestions(Questions questions);

    String getAnswerById(String id);

}

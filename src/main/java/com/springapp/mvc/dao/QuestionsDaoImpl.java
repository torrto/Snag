package com.springapp.mvc.dao;

import com.springapp.mvc.model.Questions;

import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
public class QuestionsDaoImpl extends AbstractDao<Integer, Questions> implements QuestionsDao {


    public void saveQuestions(List<Questions> questions) {
        persistList(questions);
    }

    public Questions getQuestionbyId(int id) {
        return getById(id);
    }
}

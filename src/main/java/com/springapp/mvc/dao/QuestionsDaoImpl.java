package com.springapp.mvc.dao;

import com.springapp.mvc.model.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
@Repository("questionsDao")
public class QuestionsDaoImpl extends AbstractDao<Integer, Questions> implements QuestionsDao {


    public void saveQuestions(Questions questions) {
        persist(questions);
    }

    public Questions getQuestionbyId(int id) {
        return getById(id);
    }
}

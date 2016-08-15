package com.springapp.mvc.model;

import java.util.List;

/**
 * Created by rhy704 on 8/15/16.
 */
public class QuestionsWrapper {

    private List<Questions> questions;

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
}

package com.springapp.mvc.dao;

import com.springapp.mvc.model.Questions;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhy704 on 8/14/16.
 */
@Repository("questionsDao")
public class QuestionsDaoImpl extends AbstractDao<Integer, Questions> implements QuestionsDao {


    public void saveQuestions(Questions questions) {
        persist(questions);
    }

//    public Questions getQuestionbyId(int id) {
//        return getById(id);
//    }

    public String getAnswerById(String id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Questions questions = (Questions) criteria.list().get(0);
        return questions.getAnswer();
    }

    public List<String> getAllAnswers() {
        Criteria criteria = createEntityCriteria();
        List<Questions> all = (List<Questions>) criteria.list();
        List<String> answers = new ArrayList<String>();
        for(int i = 0; i < all.size(); i++){
            answers.add(all.get(i).getAnswer());
        }
        return answers;
    }
}

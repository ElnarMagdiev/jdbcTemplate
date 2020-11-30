package com.springapp.dao;

import com.springapp.models.Question;

import java.util.List;

public interface QuestionDao {
    long add(Question question);
    void update(Question question);
    void delete(Question question);
    Question getQuestionById(long id);
    List<Question> getAllQuestions();
}

package com.springapp.services;

import com.springapp.models.Question;

import java.util.List;


public interface QuestionService {
    void add(Question question);
    void update(Question question);
    void delete(Question question);
    Question getQuestionById(long id);
    List<Question> getAllQuestions();
}

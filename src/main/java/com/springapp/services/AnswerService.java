package com.springapp.services;

import com.springapp.models.Answer;

import java.util.List;

public interface AnswerService {
    void add(Answer answer);
    void update(Answer answer);
    void delete(Answer answer);
    Answer getAnswerById(long id);
    List<Answer> getAllAnswers();
    List<Answer> getAnswersByQuestionId(long question_id);
    long findCorrectAnswerByQuestionId(long question_id);
}

package com.springapp.services.impl;

import com.springapp.dao.AnswerDao;
import com.springapp.models.Answer;
import com.springapp.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    @Transactional
    public void add(Answer answer) {
        answerDao.add(answer);
    }

    @Override
    @Transactional
    public void update(Answer answer) {
        answerDao.update(answer);
    }

    @Override
    @Transactional
    public void delete(Answer answer) {
        answerDao.delete(answer);
    }

    @Override
    @Transactional
    public Answer getAnswerById(long id) {
        return answerDao.getAnswerById(id);
    }

    @Override
    @Transactional
    public List<Answer> getAllAnswers() {
        return answerDao.getAllAnswers();
    }

    @Override
    @Transactional
    public List<Answer> getAnswersByQuestionId(long question_id) {
        return answerDao.getAnswersByQuestionId(question_id);
    }

    @Override
    @Transactional
    public long findCorrectAnswerByQuestionId(long question_id) {
        return answerDao.findCorrectAnswerByQuestionId(question_id);
    }
}

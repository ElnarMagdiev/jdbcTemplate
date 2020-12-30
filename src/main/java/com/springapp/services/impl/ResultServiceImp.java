package com.springapp.services.impl;

import com.springapp.dao.ResultDao;
import com.springapp.models.Result;
import com.springapp.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ResultServiceImp implements ResultService {

    private ResultDao resultDao;

    @Autowired
    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Override
    @Transactional
    public void add(Result result) {
        resultDao.add(result);
    }

    @Override
    @Transactional
    public List<Result> getResultsByUserId(long id) {
        List<Result> results = resultDao.getResultsByUserId(id);
        return results;
    }

    @Override
    @Transactional
    public List<Result> getAllResults() {
        List<Result> results = resultDao.getAllResults();
        return results;
    }

    @Override
    @Transactional
    public int findBetterResults(int score) {
        int count = resultDao.findBetterResults(score);
        return count;
    }

    @Override
    @Transactional
    public int findWorseResults(int score) {
        int count = resultDao.findWorseResults(score);
        return count;
    }

    @Override
    @Transactional
    public List<Result> getAllCompletedResults() {
        List<Result> results = resultDao.getAllCompletedResults();
        return results;
    }
}

package com.springapp.dao;

import com.springapp.models.Result;

import java.util.List;

public interface ResultDao {
    long add(Result result);
    Result getResultById(long id);
    List<Result> getResultsByUserId(long id);
    List<Result> getAllResults();
    int findBetterResults(int score);
    int findWorseResults(int score);
    List<Result> getAllCompletedResults();
}

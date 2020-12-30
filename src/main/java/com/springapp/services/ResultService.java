package com.springapp.services;

import com.springapp.models.Result;

import java.util.List;

public interface ResultService {
    void add(Result result);
    List<Result> getResultsByUserId(long id);
    List<Result> getAllResults();
    int findBetterResults(int score);
    int findWorseResults(int score);
    List<Result> getAllCompletedResults();
}

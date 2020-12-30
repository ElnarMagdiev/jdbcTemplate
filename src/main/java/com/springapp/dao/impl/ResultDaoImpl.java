package com.springapp.dao.impl;

import com.springapp.dao.ResultDao;
import com.springapp.models.Result;
import com.springapp.utilities.ResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Result result) {
        String sql = "INSERT INTO schema_web.results(user_id, score, complete) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, result.getUser_id(), result.getScore(), result.isComplete());
    }

    @Override
    public List<Result> getResultsByUserId(long id) {
        String sql = "SELECT * FROM schema_web.results WHERE user_id=?";
        List<Result> results = jdbcTemplate.query(sql, new ResultMapper(), new Object[]{id});
        return results;
    }

    @Override
    public List<Result> getAllResults() {
        String sql = "SELECT * FROM schema_web.results";
        List<Result> results = jdbcTemplate.query(sql, new ResultMapper());
        return results;
    }

    @Override
    public int findBetterResults(int score) {
        String sql = "SELECT * FROM schema_web.results WHERE score > ?";
        List<Result> results = jdbcTemplate.query(sql, new ResultMapper(), new Object[]{score});
        return results.size();
    }

    @Override
    public int findWorseResults(int score) {
        String sql = "SELECT * FROM schema_web.results WHERE score < ?";
        List<Result> results = jdbcTemplate.query(sql, new ResultMapper(), new Object[]{score});
        return results.size();
    }

    @Override
    public List<Result> getAllCompletedResults() {
        String sql = "SELECT * FROM schema_web.results WHERE complete";
        List<Result> results = jdbcTemplate.query(sql, new ResultMapper());
        return results;
    }
}

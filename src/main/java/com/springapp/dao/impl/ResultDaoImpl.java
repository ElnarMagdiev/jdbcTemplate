package com.springapp.dao.impl;

import com.springapp.dao.ResultDao;
import com.springapp.models.Result;
import com.springapp.utilities.ResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ResultDaoImpl implements ResultDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Result result) {
        String sql = "INSERT INTO schema_web.results(user_id, score, complete) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, result.getUser_id(), result.getScore(), result.isComplete());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sql, new String[] {"id"});
                    ps.setLong(1, result.getUser_id());
                    ps.setInt(2, result.getScore());
                    ps.setBoolean(3, result.isComplete());
                    return ps;
                },
                keyHolder);

        return (long)keyHolder.getKey();
    }

    @Override
    public Result getResultById(long id) {
        String sql = "SELECT * FROM schema_web.results WHERE id=?";
        Result result = (Result) jdbcTemplate.queryForObject(sql, new ResultMapper(), new Object[]{id});
        return result;
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

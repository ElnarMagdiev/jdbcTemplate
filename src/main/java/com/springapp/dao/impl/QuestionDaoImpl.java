package com.springapp.dao.impl;

import com.springapp.dao.QuestionDao;
import com.springapp.models.Question;
import com.springapp.utilities.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Question question) {
        String sql = "INSERT INTO schema_web.questions(content) VALUES (?)";
//        jdbcTemplate.update(sql, question.getContent());
        String content = question.getContent();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(sql, new String[] {"id"});
                    ps.setString(1, content);
                    return ps;
                },
                keyHolder);

        return (long)keyHolder.getKey();
        //
    }

    @Override
    public void update(Question question) {
        String sql = "UPDATE schema_web.questions SET content = ? WHERE id = ?";
        jdbcTemplate.update(sql, question.getContent(), question.getId());
    }

    @Override
    public void delete(Question question) {
        String sql = "DELETE FROM schema_web.questions WHERE id = ?";
        jdbcTemplate.update(sql, question.getId());
    }

    @Override
    public Question getQuestionById(long id) {
        String sql = "SELECT * FROM schema_web.questions WHERE id = ?";
        return (Question) jdbcTemplate.queryForObject(sql, new QuestionMapper() ,new Object[]{id});
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM schema_web.questions";
        List<Question> questions = jdbcTemplate.query(sql,
                new QuestionMapper());

        return questions;
    }
}

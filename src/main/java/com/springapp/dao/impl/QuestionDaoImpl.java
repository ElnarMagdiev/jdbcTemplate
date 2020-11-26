package com.springapp.dao.impl;

import com.springapp.dao.QuestionDao;
import com.springapp.models.Question;
import com.springapp.utilities.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Question question) {
        String sql = "INSERT INTO schema_web.questions(id, content) VALUES (?, ?)";
        jdbcTemplate.update(sql, question.getId(), question.getContent());
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
        return (Question) jdbcTemplate.queryForObject(sql, new QuestionMapper());
    }

    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM schema_web.questions";
        List<Question> questions = jdbcTemplate.query(sql,
                new QuestionMapper());

        return questions;
    }
}

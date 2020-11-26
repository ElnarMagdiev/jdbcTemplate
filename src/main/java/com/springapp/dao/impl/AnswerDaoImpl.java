package com.springapp.dao.impl;

import com.springapp.dao.AnswerDao;
import com.springapp.models.Answer;
import com.springapp.utilities.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AnswerDaoImpl implements AnswerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Answer answer) {
        String sql = "INSERT INTO schema_web.answers(id, content, question_id" +
                ", correct) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, answer.getId(), answer.getContent()
                , answer.getQuestion_id(), answer.isCorrect());
    }

    @Override
    public void update(Answer answer) {
        String sql = "UPDATE schema_web.answers SET content = ?, question_id = ?, " +
                "correct = ? WHERE id = ?";
        jdbcTemplate.update(sql, answer.getContent(), answer.getQuestion_id(), answer.isCorrect(), answer.getId());
    }

    @Override
    public void delete(Answer answer) {
        String sql = "DELETE FROM schema_web.answers WHERE id = ?";
        jdbcTemplate.update(sql, answer.getId());
    }

    @Override
    public Answer getAnswerById(long id) {
        String sql = "SELECT * FROM schema_web.answers WHERE id = ?";
        return (Answer) jdbcTemplate.queryForObject(sql, new AnswerMapper());
    }

    @Override
    public List<Answer> getAllAnswers() {
        String sql = "SELECT * FROM schema_web.answers";
        List<Answer> answers = jdbcTemplate.query(sql, new AnswerMapper());
        return answers;
    }

    @Override
    public List<Answer> getAnswersByQuestionId(long question_id) {
        String sql = "SELECT * FROM schema_web.answers WHERE question_id = ?";
        List<Answer> answers = new ArrayList<Answer>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, question_id);
        for (Map row: rows) {
            Answer answer = new Answer();
            answer.setId((long) row.get("id"));
            answer.setContent((String) row.get("content"));
            answer.setCorrect((boolean) row.get("correct"));
            answer.setQuestion_id((long) row.get("question_id"));
            answers.add(answer);
        }
        return answers;
    }

    @Override
    public long findCorrectAnswerByQuestionId(long question_id) {
        for (Answer answer: getAnswersByQuestionId(question_id)) {
            if (answer.isCorrect()) {
                return answer.getId();
            }
        }
        return (long) -1;
    }
}

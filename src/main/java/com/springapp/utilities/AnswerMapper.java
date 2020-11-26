package com.springapp.utilities;

import com.springapp.models.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Answer answer = new Answer();
        answer.setId(resultSet.getLong("ID"));
        answer.setQuestion_id(resultSet.getLong("QUESTION_ID"));
        answer.setContent(resultSet.getString("CONTENT"));
        answer.setCorrect(resultSet.getBoolean("CORRECT"));
        return answer;
    }
}

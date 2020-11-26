package com.springapp.utilities;

import com.springapp.models.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Question question = new Question();
        question.setId(resultSet.getLong("ID"));
        question.setContent(resultSet.getString("CONTENT"));
        return question;
    }
}

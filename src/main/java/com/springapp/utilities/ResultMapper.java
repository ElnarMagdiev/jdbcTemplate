package com.springapp.utilities;

import com.springapp.models.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Result result = new Result();
        result.setId(resultSet.getLong("ID"));
        result.setUser_id(resultSet.getLong("USER_ID"));
        result.setScore(resultSet.getInt("SCORE"));
        result.setComplete(resultSet.getBoolean("COMPLETE"));
        return result;
    }
}

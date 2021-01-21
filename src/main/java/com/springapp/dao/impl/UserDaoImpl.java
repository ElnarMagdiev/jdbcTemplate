package com.springapp.dao.impl;

import com.springapp.dao.UserDao;
import com.springapp.models.Role;
import com.springapp.models.User;
import com.springapp.utilities.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUser(String username) {
        String sql = "SELECT id, username, password FROM schema_web.users WHERE username=?";
        User userFromDb = (User) jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[]{username});
        userFromDb.setRoles(getRolesByUserId(userFromDb.getId()));
        return userFromDb;
    }

    @Override
    public List<Role> getRolesByUserId(Long id) {
        String sql = "SELECT role FROM schema_web.roles WHERE user_id=?";
        List<Role> roles = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);
        for (Map row:
             rows) {
            roles.add(Role.valueOf((String) row.get("role")));
        }
        return roles;
    }


    @Override
    public User getUserByUserId(long id) {
        String sql = "SELECT * FROM schema_web.users WHERE id=?";
        return (User) jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[]{id});
    }
}

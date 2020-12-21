package com.springapp.dao;

import com.springapp.models.Role;
import com.springapp.models.User;

import java.util.List;

public interface UserDao {
    User getUser(String username);
    List<Role> getRolesByUserId(Long id);
}

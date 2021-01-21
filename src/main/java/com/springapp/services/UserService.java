package com.springapp.services;

import com.springapp.models.Role;
import com.springapp.models.User;

import java.util.List;

public interface UserService {
    User getUser(String username);
    List<Role> getRolesByUserId(Long id);
    User getUserByUserId(long id);
}

package com.springapp.services.impl;

import com.springapp.models.Role;
import com.springapp.models.User;
import com.springapp.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Transactional
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername("user");
        user.setPassword("123");
        user.setId((long)1);
        List<Role> roles = new ArrayList<>();
        roles.add(Role.USER);
        roles.add(Role.ADMIN);
        user.setRoles(roles);
        return user;
    }
}

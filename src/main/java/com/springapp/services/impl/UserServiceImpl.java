package com.springapp.services.impl;

import com.springapp.dao.UserDao;
import com.springapp.models.Role;
import com.springapp.models.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String username) {
        User user = userDao.getUser(username);
        return user;
    }

    @Override
    public List<Role> getRolesByUserId(Long id) {
        List<Role> roles = userDao.getRolesByUserId(id);
        return roles;
    }

    @Override
    public User getUserByUserId(long id) {
        return userDao.getUserByUserId(id);
    }
}

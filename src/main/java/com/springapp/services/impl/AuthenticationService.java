package com.springapp.services.impl;

import com.springapp.dao.UserDao;
import com.springapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUser(s);
        UserDetails userDetails = (UserDetails)
                new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(), user.getRoles());
        return userDetails;
    }
}

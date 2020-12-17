package com.springapp.services;

import com.springapp.models.User;

public interface UserService {
    User getUserByUsername(String username);
}

package com.springapp.models;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private boolean isActive;
    private List<Role> roles;

    public User() {
    }

    public User(String username, String password, boolean isActive, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

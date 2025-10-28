package com.example.week8lab;

import com.example.week8lab.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserInfo {

    private List<User> users = new ArrayList<>();

    public UserInfo() {
        users = new ArrayList<>();
        users.add(new User("Josh","josh@example.com", "abcd"));
        users.add(new User("Eva","eva@example.com", "abcd"));
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean authenticateUser(String name,String email, String password) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

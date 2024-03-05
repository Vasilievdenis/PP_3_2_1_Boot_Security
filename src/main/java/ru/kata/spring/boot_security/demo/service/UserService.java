package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Integer id);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Integer id);
    User findByUserName (String name);
}

package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao {
    User findByUserName(String name);
    List<User> getUsers();
    User getUser(int id);
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);


}

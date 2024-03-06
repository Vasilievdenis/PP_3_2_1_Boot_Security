package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    void removeUser(int id);

    User findByUserName(String name);


    void removeUser(Integer id);

    List<User> getUsers();

    User getUser(Integer id);

    User getUser(int id);

    void addUser(User user);

    void updateUser(User user);
}

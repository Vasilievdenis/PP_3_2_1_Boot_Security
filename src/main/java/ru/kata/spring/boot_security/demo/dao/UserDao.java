package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Optional;
import java.util.Set;


@Repository
public interface UserDao {

    User findByUserName(String name);

    Set<User> getUsers();

    User getUser(Integer id);

    void removeUser(Integer id);

    void addUser(User user);

    void updateUser(User user);

}

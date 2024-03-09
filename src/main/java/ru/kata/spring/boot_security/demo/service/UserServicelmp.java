package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;

@Service
@Transactional
public class UserServicelmp implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServicelmp(UserDao userDao, PasswordEncoder passwordEncoder) {

        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    @Override
    public Set<User> getUsers() {

        return userDao.getUsers();
    }

    @Transactional(readOnly = true)
    @Override

    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }


    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Override
    public void removeUser(Integer id) {
        userDao.removeUser(id);

    }

    @Override
    public User findByUserName(String name) {
        return userDao.findByUserName(name);
    }
}

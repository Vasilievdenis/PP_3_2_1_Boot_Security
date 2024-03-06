package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Service
@Transactional
public class UserServicelmp implements UserService {
    public UserDao userDao;


    @Autowired
    public UserServicelmp(UserDao userDao) {

        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {

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

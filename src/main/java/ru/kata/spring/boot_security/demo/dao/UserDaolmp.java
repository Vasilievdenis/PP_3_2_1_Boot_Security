package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserDaolmp implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public Set<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public User getUser(Integer id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Integer id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User findByUserName(String name) {
        String query = "select u from User u left join fetch u.roles where u.name=:name";
        User user = entityManager.createQuery(query, User.class).setParameter("name", name).getSingleResult();
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " not found");
        }
        return user;
    }
}
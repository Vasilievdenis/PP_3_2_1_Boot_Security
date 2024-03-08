package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDaolmp implements RoleDao {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public Set<Role> getRoles() {
        return entityManager.createQuery("from Role ", Role.class).getResultStream().collect(Collectors.toSet());
    }
}
package ru.kata.spring.boot_security.demo.model;

import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@EqualsAndHashCode
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_role")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {

    }

    

    public Collection<User> getUsers() {
        return users;
    }
    public String getName() {
        return name;
    }
    public String setName(String name) {
        return this.name = name;
    }
public Integer getId(){
        return id;
}
public void setId(Integer id) {
        this.id = id;
}
    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (!id.equals(role.id)) return false;
        if (!name.equals(role.name)) return false;
        return users.equals(role.users);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }
}

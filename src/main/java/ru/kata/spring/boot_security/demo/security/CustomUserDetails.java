package ru.kata.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails extends User implements UserDetails {
    @Override
    public Set<? extends GrantedAuthority> getAuthorities() {
        return getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }
    @Override
    public String getPassword() {
        return null; }
    @Override
    public String getUsername() {
        return null;
    }
}

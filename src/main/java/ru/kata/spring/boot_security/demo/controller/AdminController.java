package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping(value = "/")
    public String getUsers(Model model, Principal principal) {
        User user = userService.findByUserName(principal.getName());
                model.addAttribute("user", user);
                List<User> list = userService.getUsers();
                model.addAttribute("list", list);
        return "users";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("roles", roleService.getRoles());
        userService.addUser(user);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.updateUser(user);
        return "redirect:/admin/";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String removeUsers(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/{id}/update")
    public String getEditUserForm(Model model, @PathVariable("id") int id) {
        model.addAttribute(userService.getUser(id));
        return "userUpdate";
    }
    @GetMapping("/new")
    public String createUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        Collection<Role> roles = roleService.getRoles();
        model.addAttribute("role", roles);
        return "userCreate";
    }
}


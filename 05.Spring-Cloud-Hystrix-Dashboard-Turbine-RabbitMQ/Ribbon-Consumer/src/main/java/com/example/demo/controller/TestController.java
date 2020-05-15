package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lovrth
 * @since 2020/5/14
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("info")
    public String getInfo() {
        return "Ribbon-Consumer";
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("testCache")
    public void testCache() {
        userService.getUser(1L);
        userService.getUser(1L);
        userService.getUser(1L);
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("user/save")
    public String saveUser() {
        return userService.saveUser();
    }

    @GetMapping("user/update")
    public void updateUser() {
        userService.updateUser();
    }

    @GetMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

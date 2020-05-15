package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lovrth
 * @since 2020/5/15
 */
@RestController
@RequestMapping("user")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return userService.getOne(id);
    }

    @GetMapping
    public List<User> getList() {
        return userService.getList();
    }

    @PostMapping
    public void save() {
        User user = new User(1L, "lovrth", "123456");
        userService.save(user);
    }

    @PutMapping
    public void update() {
        User user = new User(1L, "mrbird", "123456");
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}

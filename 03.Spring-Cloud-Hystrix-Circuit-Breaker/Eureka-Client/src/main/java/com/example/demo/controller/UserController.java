package com.example.demo.controller;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lovrth
 * @since 2020/5/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        log.info("获取用户id为 " + id + "的信息");
        return new User(id, "lovrth", "123456");
    }

    @GetMapping
    public List<User> getList() {
        List<User> list = new ArrayList<>();
        list.add(new User(1L, "lovrth", "123456"));
        list.add(new User(2L, "scott", "123456"));
        log.info("获取用户信息 " + list);
        return list;
    }

    @PostMapping
    public void save(@RequestBody User user) {
        log.info("新增用户成功 " + user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        log.info("更新用户成功 " + user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.info("删除用户成功 " + id);
    }
}

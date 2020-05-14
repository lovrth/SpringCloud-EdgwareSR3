package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lovrth
 * @since 2020/5/14
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("info")
    public String getInfo() {
        return "Eureka-Consumer";
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return this.restTemplate.getForEntity("http://Server-Provider/user/{id}", User.class, params).getBody();
    }

    @GetMapping("user")
    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
    }

    @GetMapping("user/save")
    public String saveUser() {
        User user = new User(1L, "lovrth", "123456");
        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @GetMapping("user/update")
    public void updateUser() {
        User user = new User(1L, "lovrth2", "123456");
        this.restTemplate.put("http://Server-Provider/user", user);
    }

    @GetMapping("user/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        this.restTemplate.delete("http://Server-Provider/user/{id}", id);
    }
}

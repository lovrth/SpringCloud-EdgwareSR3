package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

//    @GetMapping("user")
//    public List<User> getUsers() {
//        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
//    }
//
//    @GetMapping("user/save")
//    public String saveUser() {
//        User user = new User(1L, "lovrth", "123456");
//        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/user", user, null).getStatusCode();
//        if (status.is2xxSuccessful()) {
//            return "新增用户成功";
//        } else {
//            return "新增用户失败";
//        }
//    }
//
//    @GetMapping("user/update")
//    public void updateUser() {
//        User user = new User(1L, "lovrth2", "123456");
//        this.restTemplate.put("http://Server-Provider/user", user);
//    }
//
//    @GetMapping("user/delete/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        this.restTemplate.delete("http://Server-Provider/user/{id}", id);
//    }
}

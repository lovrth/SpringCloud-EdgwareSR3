package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lovrth
 * @since 2020/5/15
 */
@FeignClient(value = "Server-Provider",fallback = UserServiceFallback.class)
public interface UserService {

    /** 注意参数入默认value值 */
    @GetMapping("user/{id}")
    User getOne(@PathVariable("id") Long id);

    @GetMapping("user")
    List<User> getList();

    @PostMapping("user")
    void save(@RequestBody User user);

    @PutMapping("user")
    void update(@RequestBody User user);

    @DeleteMapping("user/{id}")
    void delete(@PathVariable("id") Long id);
}
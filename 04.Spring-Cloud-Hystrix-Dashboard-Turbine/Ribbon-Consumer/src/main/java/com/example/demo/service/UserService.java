package com.example.demo.service;

import com.example.demo.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lovrth
 * @since 2020/5/14
 */
@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    public String getInfo() {
        return "Eureka-Consumer";
    }

    /** 命令名称为getUserById，组名为userGroup，线程池名称getUserThread */
    @CacheResult
    @HystrixCommand(fallbackMethod = "getUserDefault", commandKey = "getUserById", groupKey = "userGroup",
            threadPoolKey = "getUserThread")
    public User getUser(Long id) {
        log.info("获取用户信息(查看线程名称)");
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return this.restTemplate.getForEntity("http://Server-Provider/user/{id}", User.class, params).getBody();
    }

    /** 方法的参数及返回值类型一致 */
    @HystrixCommand(fallbackMethod = "getUserDefault2")
    public User getUserDefault(Long id) {
        String a = null;
        // 测试服务降级
        a.toString();
        User user = new User();
        user.setId(-1L);
        user.setUsername("defaultUser");
        user.setPassword("123456");
        return user;
    }

    public User getUserDefault2(Long id) {
        User user = new User();
        user.setId(-2L);
        user.setUsername("defaultUser2");
        user.setPassword("123456");
        return user;
    }

    public List<User> getUsers() {
        return this.restTemplate.getForObject("http://Server-Provider/user", List.class);
    }


    public String saveUser() {
        User user = new User(1L, "lovrth", "123456");
        HttpStatus status = this.restTemplate.postForEntity("http://Server-Provider/user", user, null).getStatusCode();
        if (status.is2xxSuccessful()) {
            return "新增用户成功";
        } else {
            return "新增用户失败";
        }
    }

    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public void updateUser() {
        User user = new User(1L, "lovrth2", "123456");
        this.restTemplate.put("http://Server-Provider/user", user);
    }

    public void deleteUser(Long id) {
        this.restTemplate.delete("http://Server-Provider/user/{id}", id);
    }
}

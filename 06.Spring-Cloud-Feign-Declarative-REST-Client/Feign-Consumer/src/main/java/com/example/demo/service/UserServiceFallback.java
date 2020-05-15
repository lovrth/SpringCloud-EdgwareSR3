package com.example.demo.service;

import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lovrth
 * @since 2020/5/15
 */
@Component
public class UserServiceFallback implements UserService{

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public User getOne(Long id) {
        return new User(-1L, "default", "123456");
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public void save(User user) {
        log.info("test fallback");
    }

    @Override
    public void update(User user) {
        log.info("test fallback");
    }

    @Override
    public void delete(Long id) {
        log.info("test fallback");
    }
}

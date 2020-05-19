package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lovrth
 * @since 2020/5/19
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("check")
    private String check() {
        logger.info("health check");
        return "ok";
    }

    @GetMapping("hello")
    public String hello() {
        logger.info("hello");
        return "hello from server provider";
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lovrth
 * @since 2020/5/18
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${message}")
    private String message;

    @GetMapping("message")
    public String getMessage(){
        return this.message;
    }
}

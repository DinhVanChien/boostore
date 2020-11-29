package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
	@Autowired
    private RedisTemplate template;

    @GetMapping("/api/v1/redis")
    public String test() {
        // Set giá trị của key "loda" là "hello redis"
        template.opsForValue().set("loda","hello world");

        // In ra màn hình Giá trị của key "loda" trong Redis
        return "Value of key loda: " + template.opsForValue().get("loda");
    }
}

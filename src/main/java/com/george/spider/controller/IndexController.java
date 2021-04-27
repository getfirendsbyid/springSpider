package com.george.spider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class IndexController {

    @RequestMapping("/say")
    public String sayHello() {
        return "hello world";
    }

    
}

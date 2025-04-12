package com.ibusah.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    // endpoint to return hello world
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}

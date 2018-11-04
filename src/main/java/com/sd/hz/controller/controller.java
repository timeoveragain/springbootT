package com.sd.hz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World,Spring boot";
    }
}

package com.movieticket.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/admin/test")
    public String test() {
        return "Admin Working";
    }
}

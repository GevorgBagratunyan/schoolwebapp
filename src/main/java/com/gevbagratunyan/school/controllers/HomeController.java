package com.gevbagratunyan.school.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "Hi! You are on the HomePage";
    }

    @GetMapping("/authority1")
    public String authority1() {
        return "This authority can access users and admins";
    }

    @GetMapping("/authority2")
    public String authority2() {
        return "This authority can access only admins";
    }
}

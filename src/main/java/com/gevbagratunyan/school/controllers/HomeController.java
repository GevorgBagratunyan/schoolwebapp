package com.gevbagratunyan.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@Validated
@RequestMapping("api/home")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("authority1")
    public String authority1() {
        return "authority1";
    }

    @GetMapping("authority2")
    public String authority2() {
        return "authority2";
    }
}

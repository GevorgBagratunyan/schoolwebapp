package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.service.services.UserService;
import com.gevbagratunyan.school.transfer.user.request.LoginRequest;
import com.gevbagratunyan.school.transfer.user.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/")
public class HomeController {

    UserService userService;

    @GetMapping
    public String homePage() {
        return "index";
    }

    //DONE
    @GetMapping("login")
    public String login() {
        return "login";
    }

    //DONE
    @PutMapping("/logout/{id}")
    public ResponseEntity<Void> logout(@PathVariable Long id) {
        userService.setLoggedIn(id, false);
        return ResponseEntity.ok().build();
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

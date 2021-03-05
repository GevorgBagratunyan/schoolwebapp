//package com.gevbagratunyan.school.controllers;
//
//import com.gevbagratunyan.school.service.security.AuthenticationService;
//import com.gevbagratunyan.school.transfer.admin.request.AdminLoginRequest;
//import com.gevbagratunyan.school.transfer.user.request.UserLoginRequest;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping("/authentication")
//public class AuthenticationController {
//
//    private final AuthenticationService authenticationService;
//
//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @GetMapping
//    public String homePage(){
//        return "Hi! You are on the Authentication Page";
//    }
//
//    @PostMapping("/login/user")
//    public void login(@Valid @RequestBody UserLoginRequest request) {
//        authenticationService.login(request);
//    }
//
//    @PostMapping("/login/admin")
//    public void login(@Valid @RequestBody AdminLoginRequest request) {
//        authenticationService.login(request);
//    }
//
//    @PutMapping("/logout/user/{id}")
//    public void logoutUser(@PathVariable Long id) {
//        authenticationService.logoutUser(id);
//    }
//
//    @PutMapping("/logout/admin/{id}")
//    public void logoutAdmin(@PathVariable Long id) {
//        authenticationService.logoutAdmin(id);
//    }
//}

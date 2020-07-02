package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    //the url
    @GetMapping("/login")
    public String showLoginForm() {
        //the view it's returning
        return "users/login";
    }

//    @PostMapping("/logout")
//    public String logOut() {
//        user.logout();
//        return "users/login";
//    }

}

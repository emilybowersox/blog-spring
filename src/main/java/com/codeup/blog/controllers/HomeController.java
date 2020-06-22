package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//This class should have one method with a GetMapping for /.
// It should return a string that says "This is the landing page!".

import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "This is the landing page!";
    }

}

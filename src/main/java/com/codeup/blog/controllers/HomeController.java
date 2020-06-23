package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//This class should have one method with a GetMapping for /.
// It should return a string that says "This is the landing page!".

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
//    @ResponseBody
    //had to get rid of @Response body in order to make it return the home.html page
    //vs. just returning as text
    public String home(){
        return "home";
    }

    @GetMapping("/{name}")
    public String homepage(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }


}

package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    //all using path variables!
    //example:
    //
//    @GetMapping("/ads/{id}")
//    @ResponseBody
//    public String show(@PathVariable long id){
//        return "show ad id: " + id;
//    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable long num1, @PathVariable long num2) {
        return "show addition results: " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable long num1, @PathVariable long num2) {
        return "show subtraction results: " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable long num1, @PathVariable long num2) {
        return "show multiplication results: " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable long num1, @PathVariable long num2) {
        return "show division results: " + (num1 / num2);
    }


}

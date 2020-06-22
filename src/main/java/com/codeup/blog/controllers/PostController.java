package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    //method GET
    @GetMapping("/posts")
    //could use @RequestMapping instead of @GetMapping^, but it's much longer so...
    //the latest version of Spring has eliminated the need for this alternative
    //even though there are shorter alternatives now (GetMapping)
    //@RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String getIndex() {
        return "Here's the index page of posts.";
    }

    //method GET
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getPost(@PathVariable long id) {
        return "Here's the individual post you searched for: " + id;
    }

    //method GET
    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm() {
        return "Here's the form to create a new post.";
    }

    //method POST
    //can't have two methods mapped to the same url??
    //this was supposed to be @PostMapping not @GetMapping
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post!";
    }


}

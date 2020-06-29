package com.codeup.blog.controllers;

import com.codeup.blog.daos.PostRepository;
import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    // These two next steps are often called dependency injection,
    // where we create a Repository instance and initialize it in the controller class constructor.
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }
//    By extending JpaRepository, we inherit the CRUD functionality that the Spring framework provides,
//    including methods for retrieving an Iterable Interface1 with all the ads (findAll),
//    a specific ad (getOne), inserting or updating an ad (save), and deleting an ad (delete).


    //the post/get-mapping is the url
    @PostMapping("/posts/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        //is id the right param?
        model.addAttribute("posts", postDao.save());
        //edit below- show that individual post that was edited
        //the "return" is the 'view' it will return
        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        model.addAttribute("posts", postDao.delete());
        return "posts/index";
    }


    ////////////////////////


//    //method GET
//    @GetMapping("/posts")
//    //could use @RequestMapping instead of @GetMapping^, but it's much longer so...
//    //the latest version of Spring has eliminated the need for this alternative
//    //even though there are shorter alternatives now (GetMapping)
//    //@RequestMapping(value = "/posts", method = RequestMethod.GET)

//    public String index(Model model) {
//        ArrayList<Post> postsList = new ArrayList<>();
//        postsList.add(new Post("1st Post", "this is my first post."));
//        postsList.add(new Post("2nd Post", "a second post"));
//        postsList.add(new Post("3nd Post", "a third post"));
//        model.addAttribute("noPostsFound", postsList.size() == 0);
//        model.addAttribute("posts", postsList);
//        return "posts/index";
//        //now they're not working.........
//    }

    //method GET
    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable long id, Model myModel) {
        myModel.addAttribute("id", id);
            // want that id to be generated- not something i type in
        myModel.addAttribute("post", new Post( "1st Post", "this is my first post."));
        return "posts/show";
    }
    //Instructions: Inside the method that shows an individual post,
    // create a new post object and pass it to the view.




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

//    Inside the method that shows an individual post, create a new post object and pass it to the view.
//    Inside the method that shows all the posts, create a new array list and add two post objects to it,
//    then pass that list to the view.








}

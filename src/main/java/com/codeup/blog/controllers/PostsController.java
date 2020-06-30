package com.codeup.blog.controllers;

import com.codeup.blog.daos.PostsRepository;
import com.codeup.blog.daos.UsersRepository;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    // These two next steps are often called dependency injection,
    // where we create a Repository instance and initialize it in the controller class constructor.
    private final PostsRepository postsDao;
    private UsersRepository usersDao;

    public PostsController(PostsRepository postsDao, UsersRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }


    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

//    By extending JpaRepository, we inherit the CRUD functionality that the Spring framework provides,
//    including methods for retrieving an Iterable Interface1 with all the ads (findAll),
//    a specific ad (getOne), inserting or updating an ad (save), and deleting an ad (delete).

    @GetMapping("/users")
    @ResponseBody
    public String users(Model model){
        model.addAttribute("users", usersDao.findAll());
        return "grabbing all the users";
    }


    //the post/get-mapping is the url
    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String edit(@PathVariable long id,
                       @RequestParam(name = "title") String title,
                       @RequestParam(name = "body") String body) {
        //find the post
        Post foundPost = postsDao.getOne(id);
        //edit the post
        foundPost.setTitle(title);
        foundPost.setBody(body);
        //save the changes
        postsDao.save(foundPost);
        return "post has been updated";

        //ADD SAVE

//        Post postToEdit = postsDao.getOne(id);
//        model.addAttribute("posts", postsDao.save());
//        //edit below- show that individual post that was edited
//        //the "return" is the 'view' it will return
//        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String delete(@PathVariable long id) {
        postsDao.deleteById(id);
        return "ad was deleted";
    }


    ////////////////////////


//    //method GET
//    @GetMapping("/posts")
//    //could use @RequestMapping instead of @GetMapping^, but it's much longer so...
//    //the latest version of Spring has eliminated the need for this alternative
//    //even though there are shorter alternatives now (GetMapping)
//    //@RequestMapping(value = "/posts", method = RequestMethod.GET)
//
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
    public String getPost(@PathVariable long id, Model model) {
        Post post = postsDao.getOne(id);
        model.addAttribute("id", id);
        model.addAttribute("post", post);
            // want that id to be generated- not something i type in
//        myModel.addAttribute("post", new Post( "1st Post", "this is my first post."));
        return "posts/show";
    }
    //Instructions: Inside the method that shows an individual post,
    // create a new post object and pass it to the view.




    //method GET
    @GetMapping("/posts/create")
    public String viewCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    //method POST
    //can't have two methods mapped to the same url??
    //this was supposed to be @PostMapping not @GetMapping
    @PostMapping("/posts/create")
    public String saveNewPost(@ModelAttribute Post newPost) {
        User postCreator = usersDao.getOne(1L);
        newPost.setCreator(postCreator);
        Post savedPost = postsDao.save(newPost);
        return "redirect:/posts/" + savedPost.getId();
    }

//    Inside the method that shows an individual post, create a new post object and pass it to the view.
//    Inside the method that shows all the posts, create a new array list and add two post objects to it,
//    then pass that list to the view.








}

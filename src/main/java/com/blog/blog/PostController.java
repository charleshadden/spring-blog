package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path="/posts", method = RequestMethod.GET)
    @ResponseBody
    private String indexPage() { return "This is the index page"; }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    private String userPosts(@PathVariable int id) { return "The user id is: " + id; }

    @RequestMapping(path="/posts/create")
    @ResponseBody
    private String createPostForm () { return "This is the create post form page"; }

    @PostMapping(path="posts/create")
    @ResponseBody
    private String createPost () { return "Creating Post"; }




}

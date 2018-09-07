package com.blog.blog.controllers;

import com.blog.blog.Post;
import com.blog.blog.services.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostsService postSvc;

    public PostController(PostsService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model vModel) {
        Post post = postSvc.findOne(id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping(path="/posts")
    private String showAllPosts(Model vModel) {
        vModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }

    @GetMapping(path="/posts/create")
    public String showCreateForm() {
        return "posts/create";
    }

//    @PostMapping(path="posts/create")
//    @ResponseBody
//    private String createPost () { return "Creating Post"; }

    @GetMapping("posts/save")
    public String createAd(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = postSvc.save(new Post(title, body));
        return "redirect:/posts/";
    }






}

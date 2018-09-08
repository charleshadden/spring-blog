package com.blog.blog.controllers;

import com.blog.blog.Post;
import com.blog.blog.services.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/save")
    public String createAd(@ModelAttribute Post post){
        postSvc.save(post);
        return "redirect:/posts/";
    }





}

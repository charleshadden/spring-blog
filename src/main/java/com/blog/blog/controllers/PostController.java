package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.services.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {


    PostsService pstSvc;

    public PostController(PostsService pstSvc) {
        this.pstSvc = pstSvc;
    }
//    private final PostsService postSvc;
//
//    public PostController(PostsService postSvc) {
//        this.postSvc = postSvc;
//    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model vModel) {
        Post post = pstSvc.findOne(id);
        vModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping(path="/posts")
    private String showAllPosts(Model vModel) {
        vModel.addAttribute("posts", vModel.findAll());
        return "posts/index";
    }

    @GetMapping("/posts")
    @ResponseBody
    public String jpaFindAllTest() {
        List<Post> posts = pstSvc.givMePosts();
        String output = "";
        for (Post post : posts) {
            output += post.toString() + "<br>";
        }
        return output;
    }

    @GetMapping(path="/posts/create")
    public String showCreateForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/save")
    public String createAd(@ModelAttribute Post post){
        post.save(post);
        return "redirect:/posts/";
    }





}

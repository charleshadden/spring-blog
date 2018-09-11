package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import com.blog.blog.services.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostsService postSvc;
    private PostRepository postDao;

    public PostController(PostsService postSvc, PostRepository postDao) {

        this.postSvc = postSvc;
        this.postDao = postDao;
    }

    @GetMapping("/posts/index")
    public String FindAll(Model vModel) {

        vModel.addAttribute("posts", postDao.findAll());

//        List<Post> posts = postSvc.findAllPosts();
//        vModel.addAttribute("posts", posts);
        return"posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String viewAd(@PathVariable("id") Long id, Model model) {
//        Post post = postSvc.findById(id);
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @RequestMapping("/posts/delete/{id}")
    public String delete(@PathVariable Long id) {
        postSvc.deletePost(id);
                return "redirect:/posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel){
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        postSvc.savePost(post);
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model vModel, @PathVariable long id) {
        Post existingPost = postSvc.findById(id);
        vModel.addAttribute("post", existingPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @ModelAttribute Post post) {
        post.setId(id);
        postSvc.savePost(post);
        return "redirect:/posts/index";
    }


}

package com.blog.blog.controllers;

import com.blog.blog.models.Comment;
import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.PostRepository;
import com.blog.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private UserRepository userDao;
    private PostRepository postDao;

    public PostController(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String FindAll(Model vModel) {
        System.out.println();

        vModel.addAttribute("posts", postDao.findAll());
        return"posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String viewAd(@PathVariable("id") Long id, Model model) {
        Post post = postDao.findById(id);
        List<Comment> comments = post.getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping("/posts/delete/{id}")
    public String delete(@PathVariable Long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name ="id") long id) {
        postDao.delete(id);
        return"redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model vModel){
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(Model vModel, @PathVariable long id) {
        vModel.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String update(@ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/posts";
    }


}

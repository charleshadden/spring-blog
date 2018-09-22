package com.blog.blog.controllers;

import com.blog.blog.models.User;
import com.blog.blog.repositories.PostRepository;
import com.blog.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    final private UserRepository userDao;
    final private PostRepository postDao;

    public ProfileController(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
    }
    @GetMapping("/profile")
    public String homePage(Model vModel) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User curruser = userDao.findByUsername(user.getUsername());

        vModel.addAttribute("user", curruser);
        return "profile";
    }



}
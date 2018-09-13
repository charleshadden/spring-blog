//package com.blog.blog.controllers;
//
//import com.blog.blog.models.User;
//import com.blog.blog.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegisterController {
//
//    private UserRepository userDao;
//
//    public RegisterController(UserRepository userDao) {
//
//        this.userDao = userDao;
//    }
//
////    @GetMapping("/register")
////    public String registerPage() {
////        return "register";
////    }
//
//    @GetMapping("/register")
//    public String showRegisterForm(Model vModel){
//         vModel.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String createUser(@ModelAttribute User user, PasswordEncoder passwordEncoder){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);
//        return "redirect:/login";
//    }
//}

package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    @ResponseBody
    private String landingPage() { return "This is the landing page!"; }


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

}

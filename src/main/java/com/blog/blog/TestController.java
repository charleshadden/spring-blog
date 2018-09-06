package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    @ResponseBody
    private String sayHi(){
        return "Well, hi!";
    }

    @RequestMapping("/howdy")
    @ResponseBody
    private String sayHowdy() {
        return "howdy";
    }

    @GetMapping("/list")
    private String listOfNames(Model viewModel) {

        List<String> names = new ArrayList<>();

        names.add("Fer");
        names.add("Justin");
        names.add("Maggie");
        names.add("Ryan");

        viewModel.addAttribute("listOfNames", names);
        viewModel.addAttribute("role", "admin");

        return "lists";
    }

    @GetMapping("/dog")
    private String dog(Model viewmodel) {

        List<String> names = new ArrayList<>();

        names.add("fraulein");
        names.add("diesel");

        viewmodel.addAttribute("listOfNames", names);

        return "dogs";
    }

}

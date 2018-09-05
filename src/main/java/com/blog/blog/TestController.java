package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}

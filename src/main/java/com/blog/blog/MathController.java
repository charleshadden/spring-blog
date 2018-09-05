package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{firstnum}/and/{nextnum}")
    @ResponseBody
    private int addNumbers (@PathVariable int firstnum, @PathVariable int nextnum) {

        return firstnum + nextnum;
    }

    @GetMapping("/multiply/{firstnum}/and/{nextnum}")
    @ResponseBody
    private int multiplyNumbers (@PathVariable int firstnum, @PathVariable int nextnum) {

        return firstnum * nextnum;
    }

    @GetMapping("/divide/{firstnum}/by/{nextnum}")
    @ResponseBody
    private int divideNumbers (@PathVariable int firstnum, @PathVariable int nextnum) {

        return firstnum / nextnum;
    }

    @GetMapping("/subtract/{firstnum}/from/{nextnum")
    @ResponseBody
    private int subtractNumbers (@PathVariable int firstnum, @PathVariable int nextnum) {

        return nextnum - firstnum;
    }

}

package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MathController {

@RequestMapping(path = "/add/{number1}/and/{number2}")
        @ResponseBody
    public int addNums(@PathVariable int number1, @PathVariable int number2){
            return number1 + number2;
    }

@GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtractNums(@PathVariable int num1, @PathVariable int num2){
        return num2 - num1;
    }

    @RequestMapping(path = "/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiplyNums(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}")
    @ResponseBody
    public int divideNums(@PathVariable int num1, @PathVariable int num2){
        return num1 / num2;
    }


}

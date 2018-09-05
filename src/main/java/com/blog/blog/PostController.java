package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String getAllPosts() {
        return "post index page";
    }

    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String showIndividualPost(@PathVariable int id) {
        return "individual post" + id;
    }


    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost() {
        return "View form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "New created post";
    }

}

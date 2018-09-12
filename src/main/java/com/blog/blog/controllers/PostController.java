package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
        private final PostService postSvc;

        public PostController(PostService postSvc) {
            this.postSvc = postSvc;
        }




        @GetMapping(path = "/posts")
    public String index(Model viewModel) {
            viewModel.addAttribute("posts", postSvc.findAll());

            return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model vModel) {
        Post newPost = postSvc.findOne(id);
        vModel.addAttribute("post", newPost);
        return "posts/show";
    }


    public String viewPost() {
        return "View form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {

            return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
            return "posts/create";
    }



}

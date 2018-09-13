package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import com.blog.blog.repositories.UserRepository;
import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
//        private PostService postSvc;
        private UserRepository userRepository;
        private PostRepository postRepository;

//        public PostController(PostService postSvc) {this.postSvc = postSvc;}



        public PostController(PostRepository postRepository, UserRepository userRepository) {
            this.postRepository = postRepository;
            this.userRepository = userRepository;
        }




        @GetMapping("/posts")
    public String index(Model viewModel) {
            viewModel.addAttribute("posts", postRepository.findAll());

            return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
//        Post newPost = postRepository.findOne(id);
        vModel.addAttribute("post", postRepository.findOne(id));
        return "posts/show";
    }


//    public String viewPost() {
//        return "View form for creating a post";
//    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String createPost() {
//
//            return "redirect:/posts";
//    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post) {
        post.setUser(userRepository.findOne(2L));
        postRepository.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
            return "posts/create";
    }

//    @GetMapping("/posts/{id}/edit")
//    public String postEditForm(@PathVariable long id, Model model) {
//        model.addAttribute("post", postRepository.findOne(id));
//        return "posts/edit";
//    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/delete")
//    public String deletePost(@RequestParam(name = "id") long id){
//        postRepository.delete(id);
//        return "redirect:/posts";
//    }


}

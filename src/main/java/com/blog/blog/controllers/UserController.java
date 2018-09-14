package com.blog.blog.controllers;

import com.blog.blog.models.Post;
import com.blog.blog.models.User;
import com.blog.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;




    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @GetMapping("/your-posts") what goes here?
//    @ResponseBody
//    public String findUser(){
//
//        User user = userRepository.findOne(2L);
//        List<Post> posts = user.getPosts();
//
//        for (Post post :posts) {
//            System.out.println("post.getId() = " + post.getId());
//        }
//
//        return "your-posts";
//
//    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userRepository.save(user);
        return "redirect:/login";
    }

}

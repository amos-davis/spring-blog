package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
        List<Post> allPosts = new ArrayList<>();



        public PostController() {
            allPosts.add(new Post("PS4", "Come and get it"));
            allPosts.add(new Post("Rolex watch", "great condition. Antique"));
            allPosts.add(new Post("Wood table", "Seats 14. Can go outdoors or indoors. Made of Oak and pine."));

        }


        @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String index(Model viewModel) {

            viewModel.addAttribute("posts", allPosts);

            return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String show(@PathVariable int id, Model vModel) {
        Post newPost = allPosts.get( (int) id - 1);
        vModel.addAttribute("post", newPost);
        return "posts/show";
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

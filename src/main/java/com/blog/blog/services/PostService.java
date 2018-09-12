package com.blog.blog.services;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;

    }

//    @GetMapping("/posts")
//    public String index(Model model) {
//        model.addAttribute("posts", postDao.findAll());
//        return "posts/index";
//    }

//    public PostService() {
//        posts = new ArrayList<>();
//        createPosts();
//    }

//    public Post findOne(long id) {
//        return postDao.get((int) id - 1);
//    }

    public Post save(Post post) {
        postRepo.save(post);
        return post;
    }

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Post findOne(long id) {
        return postRepo.findById(id);
    }



}

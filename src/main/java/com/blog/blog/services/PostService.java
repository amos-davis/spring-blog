package com.blog.blog.services;

import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PostService {
//    private List<Post> posts;

    private PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;

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



//    public List<Post> findAll() { return postDao;
//    }

//    private void createPosts() {
//        postDao. (new Post("PS4", "Come and get it"));
//        postDao.add(new Post("Rolex watch", "great condition. Antique"));
//        postDao.add(new Post("Wood table", "Seats 14. Can go outdoors or indoors. Made of Oak and pine."));
//        postDao.add(new Post("hat", "Barely worn baseball cap."));
//    }

    public Post save(Post post) {
        postDao.save(post);
        return post;
    }

    public List<Post> findAll() {
        return postDao.findAll();
    }

    public Post findOne(long id) {
        return postDao.findById(id);
    }

//    public Post update(Post post) {
//        post.
//    }

}

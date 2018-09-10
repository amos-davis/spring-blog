package com.blog.blog.services;

import com.blog.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;


    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public Post findOne(long id) {
        return posts.get((int) id - 1);
    }

    public List<Post> findAll() {
        return posts;
    }

    private void createPosts() {
        posts.add(new Post("PS4", "Come and get it"));
        posts.add(new Post("Rolex watch", "great condition. Antique"));
        posts.add(new Post("Wood table", "Seats 14. Can go outdoors or indoors. Made of Oak and pine."));
        posts.add(new Post("hat", "Barely worn baseball cap."));
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }
}

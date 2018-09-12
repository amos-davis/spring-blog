package com.blog.blog.repositories;

import com.blog.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAll();

    List<Post> findAllByTitleContaining(String partOfTitle);

    Post findById(long id);

    Post findByTitle(String title);

    List<Post> findAllByBodyContaining(String partOfBody);

    Post deleteById(long id);

    Post deleteByTitle(String title);


    Post save(Post post);





}

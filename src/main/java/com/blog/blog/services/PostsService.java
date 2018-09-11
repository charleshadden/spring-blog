package com.blog.blog.services;


import com.blog.blog.models.Post;
import com.blog.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private final PostRepository postDao;

    public PostsService(PostRepository postDao) {
        this.postDao = postDao;
    }


    public List<Post> findAllPosts() {
        return postDao.findAll();
    }

    public Post findById(Long id) {
        return postDao.findOne(id);
    }

    public void deletePost(Long id) {
        postDao.delete(id);
    }

    public Post savePost(Post posts) {
        return postDao.save(posts);
    }


}

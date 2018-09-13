package com.blog.blog.services;


import com.blog.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {



    @Autowired
    private final PostRepository postDao;

    public PostsService(PostRepository postDao) {
        this.postDao = postDao;
    }


}

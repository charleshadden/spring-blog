package com.blog.blog.services;


import com.blog.blog.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsService {

    private List<Post> posts;

    public PostsService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)id - 1);
    }

    public List<Post> findAll() {
        return posts;
    }

    private void createPosts() {
        posts.add(new Post("Check out this movie","Sicario 2 is a really good movie and you should go see it."));
        posts.add(new Post("Nike","The new ad is horrible and I can't believe a company can get away with that."));
        posts.add(new Post("2020","I wonder who will be elected?"));
    }
}

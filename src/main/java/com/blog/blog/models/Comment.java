package com.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name= "comment")
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String body;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {

    }

    public Comment(long id, String body, Post post, User user) {
        this.id = id;
        this.body = body;
        this.post = post;
        this.user = user;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Post getPost() { return post; }

    public void setPost(Post post) { this.post = post; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}

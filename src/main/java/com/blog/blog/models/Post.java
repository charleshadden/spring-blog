package com.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "post")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 5000)
    private String body;

    @ManyToOne
    private User user;



    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;



    public Post() {

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title =title;
        this.body =body;
        this.user = user;
    }

//    public Post(long id, String title, String body, User user, List<Comment> comments) {
//        this.id = id;
//        this.title = title;
//        this.body = body;
//        this.user = user;
//        this.comments = comments;
//    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) { this.comments = comments; }
}


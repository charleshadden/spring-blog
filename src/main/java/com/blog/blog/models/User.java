package com.blog.blog.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 3000)
    private String password;

    @Fetch(value = FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        posts = copy.posts;
        comments = copy.comments;
    }

    public User() {

    }

    private User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private User(long id, String username, String email, String password, List<Post> posts, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.comments = comments;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUsername() {return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email=email; }

    public String getPassword() {return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}


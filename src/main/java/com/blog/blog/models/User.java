package com.blog.blog.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 12)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 15)
    private String password;


    private User() {}

    private User(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUserName() {return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email=email; }

    public String getPassword() {return password; }
    public void setPassword(String password) { this.password = password; }



}


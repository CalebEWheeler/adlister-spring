package com.codeup.adlister.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable=false)
    private String body;

//    @OneToOne
//    private User owner;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    //why make a no arg constructor for Post?
    public Post() {}

    //Read
    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    //Create
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public long getId() {return id;}
    public String getTitle() {return title;}
    public String getBody() {return body;}
    public User getUser() {return user;}

    public void setId(long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setBody(String body) {this.body = body;}
    public void setUser(User user) {this.user=user;}
}

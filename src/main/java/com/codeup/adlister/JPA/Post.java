package com.codeup.adlister.JPA;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable=false)
    private String body;

    //why make a no arg constructor for Post?
    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getBody() {return body;}
    public void setBody(String body) {this.body = body;}
}

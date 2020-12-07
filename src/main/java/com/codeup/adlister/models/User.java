package com.codeup.adlister.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ad> ads;

    public User() {}

    //Read
    public User(long id, String username, String email, String password, List<Post> posts, List<Ad> ads) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.ads = ads;
    }

    //Create
    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        password = copy.password;
        username = copy.username;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id=id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username=username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password=password;}

    public List<Post> getPosts() {return posts;}
    public void setPosts(List<Post> posts) {this.posts = posts;}

    public List<Ad> getAds() {return ads;}
    public void setAds(List<Ad> ads) {this.ads = ads;}
}

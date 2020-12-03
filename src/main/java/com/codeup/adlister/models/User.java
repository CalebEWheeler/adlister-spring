package com.codeup.adlister.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public User() {}

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id=id;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email=email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password=password;}
    public List<Post> getPosts() {return posts;}
    public void setPosts(List<Post> posts) {this.posts = posts;}
}

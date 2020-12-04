package com.codeup.adlister.models;
import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable=false)
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public Ad() {}

    public Ad(long id, String title, String description, User user) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.user=user;
    }

    public Ad(String title, String description, User user) {
        this.title=title;
        this.description=description;
        this.user=user;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id=id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title=title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description=description;}
    public User getUser() {return user;}
    public void setUser(User user) {this.user=user;}
}

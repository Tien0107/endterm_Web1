package com.example.endterm.model;
import java.util.Date;

import jakarta.persistence.*;
// import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tu dong tao id
    private int id;
    private String title;
    private String description;
    private String content;
    //cai dat date tu dong
    @Column(name = "date", nullable = false, updatable = false)
    private Date date;

    private String image;
    //quan he nhieu nhieu
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // end quan he

    
    public Post(int id, String title, String description, String content, String image, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        // this.date = date;
        this.image = image;
        this.user = user;
    }
    //constructor
    public Post(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}

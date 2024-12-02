package com.example.endterm.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

// import com.example.endterm.model.Post;
import java.util.List;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //auto create ID
    private int id;
    private String name;
    private String email;
    //password
    @Size(min = 3, message = "Password toi thieu 3 ky tu")
    private String password;

    //quan he mot nhieu
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> post;

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //constructor
    public User(){
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

     // Thêm getter và setter cho posts
     public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    
}

package com.example.endterm.model;
import jakarta.persistence.*;
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

    //quan he mot nhieu
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> order;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    
}

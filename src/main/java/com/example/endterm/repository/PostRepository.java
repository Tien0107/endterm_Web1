package com.example.endterm.repository;
import com.example.endterm.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    
} 
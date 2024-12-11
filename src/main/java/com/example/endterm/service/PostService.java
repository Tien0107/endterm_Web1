package com.example.endterm.service;

import com.example.endterm.model.Post;
import com.example.endterm.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay post"));
    }

    //them phuong thuc kiem tra
    public Post save(Post post){
        return postRepository.save(post);
    }
    public Post update(Post post){
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}

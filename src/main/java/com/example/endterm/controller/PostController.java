package com.example.endterm.controller;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;

import com.example.endterm.service.PostService;
import com.example.endterm.model.Post;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@Controller
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(){
        
    }

    // Get all Posts    
    @GetMapping("/posts")
    @ResponseBody
    public List<Post> getPostList() {
        return postService.findAll();
    }

    // Get user by id
    @GetMapping("posts/{id}")
    @ResponseBody
    public ResponseEntity<Post> getPostbyId(@PathVariable("id") Long postId) {
        try {
            Post post = postService.findById(postId);
            return ResponseEntity.status(200).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);        
        }
        
    }
    
    // create new Post
    @PostMapping("/posts")
    @ResponseBody
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        try {
            Post newPost = postService.save(post);
            return ResponseEntity.status(201).body(newPost);    
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
        
    }
    //put
    @PutMapping("/posts/{id}")
    @ResponseBody
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long postId, @RequestBody Post updatepost){
        try {
            Post post = postService.findById(postId);
            post.setTitle(updatepost.getTitle());
            post.setDescription(updatepost.getDescription());
            post.setContent(updatepost.getContent());
            post.setDate(updatepost.getDate());
            post.setImage(updatepost.getImage());
            postService.save(post);
            return ResponseEntity.status(200).body(post);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);        
        }
        
    }

    //patch
    @PatchMapping("/posts/{id}")
    @ResponseBody
    public ResponseEntity<Post> patchPost(@PathVariable("id") Long postId, @RequestBody Post patchupdate){
        Post post = postService.findById(postId);
        if (post != null ){
            if(patchupdate.getTitle() != null){
                post.setTitle(patchupdate.getTitle());
            }
            if(patchupdate.getDescription() != null){
                post.setDescription(patchupdate.getDescription());
            }
            if(patchupdate.getContent() != null){
                post.setContent(patchupdate.getContent());
            }
            if(patchupdate.getDate() != null){
                post.setDate(patchupdate.getDate());
            }
            if(patchupdate.getImage() != null){
                post.setImage(patchupdate.getImage());
            }
            postService.save(post);
            return ResponseEntity.status(200).body(post);
    }
    return ResponseEntity.status(404).body(null);

    }
     //delete
    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public List<Post> removePostById(@PathVariable("id") Long postId){
        postService.delete(postId);
        return postService.findAll();
    }
    

}
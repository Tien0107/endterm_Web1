package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.repository.ArticleRepository;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAll(){
        return articleRepository.findAll();
    }
    
    public Article findById(Long id){
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found news"));
    }

    // public List<Article> getArticlesByDateRange(LocalDateTime startDate, LocalDateTime endDate){
    //     return articleRepository.findByPublishedDateBetween(startDate, endDate);
    // }

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }

    public Article update(Article article){
        return articleRepository.save(article);
    }
    public void delete(Long id){
        articleRepository.deleteById(id);
    }
}

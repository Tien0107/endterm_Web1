package com.example.demo.controller.client;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Article;
import com.example.demo.service.ArticleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService; 
    
    public ArticleController(){

    }

    @GetMapping("/")
    @ResponseBody
    public List<Article> getArticleList() {
        return articleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long articleId) {
        for(Article article : articleService.findAll()){
            if(article.getId() == articleId){
                return ResponseEntity.status(200).body(article);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

   // create new 
    @PostMapping("/")
    public ResponseEntity<Article> createArticle(@RequestBody Article newArticle){
        articleService.saveArticle(newArticle);
        // newArticle.setPublishedDate(LocalDateTime.now());
        return ResponseEntity.status(201).body(newArticle);
    }

    //filter
    // @GetMapping("/filter")
    // public ResponseEntity<List<Article>> getArticlesByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
    //     LocalDateTime start = LocalDateTime.parse(startDate);
    //     LocalDateTime end = LocalDateTime.parse(endDate);
    //     return ResponseEntity.ok(articleService.getArticlesByDateRange(start, end));
    // }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long articleId, @RequestBody Article updateArticle){
        Article article = articleService.findById(articleId);
        if (article != null ){
            article.setTitle(updateArticle.getTitle());
            article.setContent(updateArticle.getContent());
            articleService.saveArticle(article);
            return ResponseEntity.status(200).body(article);
        }
        return ResponseEntity.status(404).body(null);
    }

    //patch
    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Article> patchArticle(@PathVariable("id") Long ArticleId, @RequestBody Article patchupdate){
        Article article = articleService.findById(ArticleId);
        if (article != null ){
            if(patchupdate.getTitle() != null){
                article.setTitle(patchupdate.getTitle());
            }
            if(patchupdate.getContent() != null){
                article.setContent(patchupdate.getContent());
            }
            articleService.saveArticle(article);
            return ResponseEntity.status(200).body(article);
    }
    return ResponseEntity.status(404).body(null);

    }
     //delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public List<Article> removeArticleById(@PathVariable("id") Long ArticleId){
        articleService.delete(ArticleId);
        return articleService.findAll();
    }
    
    
                                                                                    
}

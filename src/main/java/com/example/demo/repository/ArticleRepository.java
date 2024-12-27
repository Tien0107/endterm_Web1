package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
// List<Article> findByPublishedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}


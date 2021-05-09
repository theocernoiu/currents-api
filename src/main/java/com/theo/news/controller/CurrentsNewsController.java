package com.theo.news.controller;

import com.theo.news.model.Article;
import com.theo.news.service.ArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CurrentsNewsController {

    @Autowired
    private ArticlesService service;

    @GetMapping({"/articles/{keyword}"})
    public ResponseEntity<List<Article>> getArticlesByKeyword(@PathVariable String keyword) {
        log.debug("Get articles for: {}", keyword);
        List<Article> articles = service.getArticlesByKeyword(keyword);
        return ResponseEntity.ok(articles);
    }

}

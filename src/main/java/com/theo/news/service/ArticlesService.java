package com.theo.news.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theo.news.model.Article;
import com.theo.news.model.News;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Slf4j
@Service
@NoArgsConstructor
public class ArticlesService {

    private final WebClient localApiClient = WebClient.create("https://api.currentsapi.services");

    @Value("${currents.api.key}")
    private String apiKey;

    @Cacheable(value = "articles", key = "#keyword")
    public List<Article> getArticlesByKeyword(String keyword) {
        String uri = "/v1/search?keywords=" + keyword + "&apiKey=" + apiKey;

        log.debug("Requesting articles for keyword: {}", keyword);
        String response = localApiClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class).log()
                .block();

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(response, News.class).getArticles();
        } catch (JsonProcessingException e) {
            log.debug("Error during json parsing", e);
        }

        return null;
    }
}

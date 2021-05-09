package com.theo.news.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    @JsonProperty("status")
    private String status;

    @JsonProperty("news")
    private List<Article> articles;

    @JsonProperty("page")
    private int page;
}

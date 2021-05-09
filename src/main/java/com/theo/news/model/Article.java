package com.theo.news.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @JsonProperty("id")
    private String id;

    @JsonProperty("category")
    private List<String> categories;

    @JsonProperty("description")
    private String description;

    @JsonProperty("author")
    private String author;

    @JsonProperty("image")
    private String image;

    @JsonProperty("language")
    private String language;

    @JsonProperty("published")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date published;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;
}

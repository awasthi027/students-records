package com.studentinfo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Article {
    private String content;
    private String author;
    private String description;
    private String publishedAt;
    private String title;
    private String url;
    private String urlToImage;
    private Source source;

    public Article(String content,
                   String author,
                   String description,
                   String publishedAt,
                   String title,
                   String url,
                   String urlToImage,
                   Source source) {
        this.content = content;
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
        this.source = source;
    }
}

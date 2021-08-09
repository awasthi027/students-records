package com.studentinfo.models;

public class Article {
    private String content;
    private String author;
    private String description;
    private String publishedAt;
    private String title;
    private String url;
    private String urlToImage;
    private Source source;

    public Article() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Article{" +
                "content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", source=" + source +
                '}';
    }
}

package com.example.pocketnews.pojo;

public class News {

    private String author;
    private String title;
    private String link;
    private String description;
    private String pubDate;
    private String url;
    private String category;

    public News(String author, String title, String link, String description, String pubDate, String url, String category) {
        this.author = author;
        this.title = title;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
        this.url = url;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

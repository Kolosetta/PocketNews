package com.example.pocketnews.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class News {
    @Element(name = "author", required = false)
    private String author;
    @Element(name = "title", required = false)
    private String title;
    @Element(name = "category", required = false)
    private String category;
    @Element(name = "link", required = false)
    private String link;
    @Element(name = "description", required = false)
    private String description;
    @Element(name = "pubDate", required = false)
    private String pubDate;
    @Element(name = "enclosure", required = false)
    private Enclosure enclosure;

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
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


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

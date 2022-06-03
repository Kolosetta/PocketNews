package com.example.pocketnews.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class NewsPojo {

    @Element(name = "author", required = false)
    private String author;
    @Element(name = "title", required = false)
    private String title;
    @Element(name = "category", required = false)
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

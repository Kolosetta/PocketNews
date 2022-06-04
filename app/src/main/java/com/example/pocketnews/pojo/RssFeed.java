package com.example.pocketnews.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


@Root(name = "rss", strict = false)
public class RssFeed {

    @ElementList(name="item", inline=true, required = false)
    @Path("channel")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}

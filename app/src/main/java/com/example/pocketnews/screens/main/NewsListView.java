package com.example.pocketnews.screens.main;

import com.example.pocketnews.pojo.News;

import java.util.List;

public interface NewsListView {
    void showRssFeed(List<News> news);
    void showLoadError();
}

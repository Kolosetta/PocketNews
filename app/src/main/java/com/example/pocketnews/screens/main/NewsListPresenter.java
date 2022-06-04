package com.example.pocketnews.screens.main;

import android.util.Log;

import com.example.pocketnews.api.ApiFactory;
import com.example.pocketnews.api.LentaRuApiService;
import com.example.pocketnews.pojo.News;
import com.example.pocketnews.pojo.RssFeed;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NewsListPresenter {
    NewsListView newsListInterface;

    public NewsListPresenter(NewsListView newsListInterface) {
        this.newsListInterface = newsListInterface;
    }

    public void loadRssFeed(){
        LentaRuApiService lentaService = ApiFactory.getInstance().getApiService();
        Disposable lentaRss = lentaService.getBodyRss()
                .subscribeOn(Schedulers.io()) //Указываем поток загрузки данных
                .observeOn(AndroidSchedulers.mainThread()) //Указываем прием данных в главном потоке
                .subscribe(new Consumer<RssFeed>() {
                    @Override
                    public void accept(RssFeed response) throws Exception { // Метод срабатывает при успешном приеме данных
                        List<News> newsList = response.getNewsList();
                        newsList.forEach(news1 -> news1.setDescription(news1.getDescription().replace("\n", "").trim()));
                        newsList.forEach(news1 -> news1.setPubDate(news1.getPubDate().substring(0,17)));
                        newsList.forEach(news1 -> news1.setDescription(news1.getDescription().substring(0, news1.getDescription().indexOf(".") + 1)));
                        newsListInterface.showRssFeed(newsList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        newsListInterface.showLoadError();
                    }
                });
    }
}

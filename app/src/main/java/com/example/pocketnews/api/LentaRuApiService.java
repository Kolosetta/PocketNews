package com.example.pocketnews.api;

import com.example.pocketnews.pojo.RssFeed;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LentaRuApiService {

    @GET("/rss")
    Observable<RssFeed> getBodyRss();
}



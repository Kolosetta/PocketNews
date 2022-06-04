package com.example.pocketnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pocketnews.pojo.News;
import com.example.pocketnews.pojo.RssFeed;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

public class NewsListActivity extends AppCompatActivity {

    NewsAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new NewsAdapter();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://lenta.ru/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        LentaService apiService = retrofit.create(LentaService.class);


        Disposable lentaRss = apiService.getBodyRss()
                .subscribeOn(Schedulers.io()) //Указываем поток загрузки данных
                .observeOn(AndroidSchedulers.mainThread()) //Указываем прием данных в главном потоке
                .subscribe(new Consumer<RssFeed>() {
                    @Override
                    public void accept(RssFeed response) throws Exception { // Метод срабатывает при успешном приеме данных
                        List<News> newsList = response.getNewsList();
                        newsList.forEach(news1 -> news1.setDescription(news1.getDescription().replace("\n", "").trim()));
                        newsList.forEach(news1 -> news1.setPubDate(news1.getPubDate().substring(0,17)));
                        newsList.forEach(news1 -> news1.setDescription(news1.getDescription().substring(0, news1.getDescription().indexOf(".") + 1)));

                        adapter.setNews(newsList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("Kek", throwable.getMessage());
                    }
                });


        recyclerView = findViewById(R.id.newsRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    interface LentaService{
        @GET("/rss")
        Observable<RssFeed> getBodyRss();
    }

}
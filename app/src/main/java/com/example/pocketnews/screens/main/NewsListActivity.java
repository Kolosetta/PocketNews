package com.example.pocketnews.screens.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.pocketnews.NewsAdapter;
import com.example.pocketnews.R;
import com.example.pocketnews.api.ApiFactory;
import com.example.pocketnews.api.LentaRuApiService;
import com.example.pocketnews.pojo.News;
import com.example.pocketnews.pojo.RssFeed;
import com.squareup.picasso.Picasso;

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

public class NewsListActivity extends AppCompatActivity implements NewsListView {

    NewsAdapter adapter;
    RecyclerView recyclerView;
    NewsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new NewsListPresenter(this);
        adapter = new NewsAdapter();
        recyclerView = findViewById(R.id.newsRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.loadRssFeed();
    }


    @Override
    public void showRssFeed(List<News> news) {
        adapter.setNews(news);
    }

    @Override
    public void showLoadError() {
        Toast.makeText(this, "Произошла ошибка получения данных", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setActionBar(@Nullable Toolbar toolbar) {
        super.setActionBar(toolbar);
        toolbar.setTitle("Kek");
    }
}
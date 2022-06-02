package com.example.pocketnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pocketnews.pojo.News;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity {

    NewsAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new NewsAdapter();


        ArrayList<News> news = new ArrayList<>();
        news.add(new News("Новость 1","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","9 декабря 2022","Животные"));
        news.add(new News("Новость 2","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","8 декабря 2022","Факты"));
        news.add(new News("Новость 3","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","17 декабря 2023","Животные"));
        news.add(new News("Новость 4","Какая-то ифна","22 декабря 2022","Политика"));
        news.add(new News("Новость 5","Какая-то ифна","3 декабря 2021","Животные"));

        adapter.setNews(news);
        recyclerView = findViewById(R.id.newsRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
package com.example.pocketnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pocketnews.pojo.News;
import com.example.pocketnews.pojo.NewsPojo;
import com.example.pocketnews.pojo.RssFeed;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
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


        ArrayList<News> news = new ArrayList<>();
        /*news.add(new News("Новость 1","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","9 декабря 2022","Животные"));
        news.add(new News("Новость 2","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","8 декабря 2022","Факты"));
        news.add(new News("Новость 3","Настройка основной панель действий требует, чтобы ваше приложение использовало тему деятельности, которая разрешает панель действий. Как запросить такую тему зависит от минимальной поддерживаемой версии Android вашим приложением","17 декабря 2023","Животные"));
        news.add(new News("Новость 4","Какая-то ифна","22 декабря 2022","Политика"));
        news.add(new News("Новость 5","Какая-то ифна","3 декабря 2021","Животные"));*/


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
                        Log.i("Lol", response.getNewsList().get(0).getAuthor());
                        adapter.setNews(response.getNewsList());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("Kek", throwable.getMessage());
                    }
                });


        adapter.setNews(news);
        recyclerView = findViewById(R.id.newsRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    interface LentaService{
        @GET("/rss")
        Observable<RssFeed> getBodyRss();
    }

}
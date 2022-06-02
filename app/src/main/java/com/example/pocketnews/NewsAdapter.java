package com.example.pocketnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketnews.pojo.News;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<News> news = new ArrayList<News>();

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News novost = news.get(position);
        holder.title.setText(novost.getTitle());
        holder.description.setText(novost.getDescription());
        holder.pubDate.setText(novost.getPubDate());
        holder.category.setText(novost.getCategory());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    protected class NewsViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private TextView pubDate;
        private TextView category;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.newsHeader);
            description = itemView.findViewById(R.id.newsDescription);
            pubDate = itemView.findViewById(R.id.newsPublishDate);
            category = itemView.findViewById(R.id.newsTag);
        }
    }


    public void setNews(List<News> news) {
        this.news = news;
    }

}

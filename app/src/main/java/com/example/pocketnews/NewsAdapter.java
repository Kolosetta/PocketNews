package com.example.pocketnews;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketnews.pojo.News;
import com.squareup.picasso.Picasso;

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
        News newsOne = news.get(position);
        holder.title.setText(newsOne.getTitle());
        holder.description.setText(newsOne.getDescription());
        holder.pubDate.setText(newsOne.getPubDate());
        holder.category.setText(newsOne.getCategory());
        Picasso.get().load(newsOne.getEnclosure().getUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    protected class NewsViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView title;
        private TextView description;
        private TextView pubDate;
        private TextView category;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.HeaderPic);
            title = itemView.findViewById(R.id.newsHeader);
            description = itemView.findViewById(R.id.newsDescription);
            pubDate = itemView.findViewById(R.id.newsPublishDate);
            category = itemView.findViewById(R.id.newsTag);
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setNews(List<News> news) {
        this.news = news;
        notifyDataSetChanged();
    }

}

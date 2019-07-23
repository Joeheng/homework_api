package com.example.retrofit_homework.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofit_homework.R;
import com.example.retrofit_homework.entity.Article;

import java.util.List;


public class AmsAdapter extends RecyclerView.Adapter<AmsAdapter.ViewHolder> {
    List<Article> articles;
    Context context;

    public AmsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AmsAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.custom_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article article = articles.get(i);
        viewHolder.title.setText(article.getTitle());
        viewHolder.content.setText(article.getContent());
        viewHolder.author.setText(article.getAuthor());
        Glide.with(context).load(article.getImage()).override(450,350).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, source, date, author, content;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            source = itemView.findViewById(R.id.tvSource);
            date = itemView.findViewById(R.id.tvDate);
            author = itemView.findViewById(R.id.tvAuthor);
            content = itemView.findViewById(R.id.tvContent);
            image = itemView.findViewById(R.id.imageView);
        }
    }
    public void addMoreItems(List<Article> articles) {
        int previousPos=this.articles.size();
        this.articles.addAll(articles);
        notifyItemRangeInserted(previousPos-1,this.articles.size());
    }
}

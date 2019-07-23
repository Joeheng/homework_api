package com.example.retrofit_homework.data;

import com.example.retrofit_homework.entity.Article;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {
        public String status;
        @SerializedName("totalResults")
        public String total;
        public List<Article> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "status='" + status + '\'' +
                ", total='" + total + '\'' +
                ", articles=" + articles +
                '}';
    }
}

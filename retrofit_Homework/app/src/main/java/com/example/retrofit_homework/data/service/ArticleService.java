package com.example.retrofit_homework.data.service;

import com.example.retrofit_homework.data.ArticleResponse;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleService {
    @GET("/v2/everything")
    Flowable<ArticleResponse> getArticleWithRx(@Query("q") String q, @Query("apiKey") String apiKey);
}

package com.example.retrofit_homework.ui.main.mvp;

import com.example.retrofit_homework.callback.InteractorResponse;
import com.example.retrofit_homework.entity.Article;

import java.util.List;

public interface ArticleMVP {
    interface View{
        void onLoadArticleSuccess(List<Article> articles);
        void onError(String message);
    }
    interface Presenter{
        void loadArticle(String q,String key);
        void onDestroy();
    }
    interface Interactor{
        void LoadArticle(String q, String key, InteractorResponse<List<Article>> response);
        void onDestory();
    }
}

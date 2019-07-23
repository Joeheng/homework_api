package com.example.retrofit_homework.ui.main;


import com.example.retrofit_homework.callback.InteractorResponse;
import com.example.retrofit_homework.entity.Article;
import com.example.retrofit_homework.ui.main.mvp.ArticleMVP;

import java.util.List;

public class MainPresenter implements ArticleMVP.Presenter {
    private ArticleMVP.View view;
    private ArticleMVP.Interactor interactor;

    public MainPresenter(ArticleMVP.View view) {
        this.view = view;
        interactor = new MainInteractor();
    }

    @Override
    public void loadArticle(String q, String key) {
        interactor.LoadArticle(q, key, new InteractorResponse<List<Article>>() {
            @Override
            public void onSuccess(List<Article> dataResponse) {
                view.onLoadArticleSuccess(dataResponse);
            }

            @Override
            public void onComplete(String message) {

            }

            @Override
            public void onError(String error) {
                view.onError(error);
            }
        });
    }

    @Override
    public void onDestroy() {
        interactor.onDestory();
    }
}

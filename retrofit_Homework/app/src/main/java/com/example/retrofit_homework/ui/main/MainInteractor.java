package com.example.retrofit_homework.ui.main;

import android.util.Log;

import com.example.retrofit_homework.callback.InteractorResponse;
import com.example.retrofit_homework.data.ArticleResponse;
import com.example.retrofit_homework.data.ServiceGenerator;
import com.example.retrofit_homework.data.service.ArticleService;
import com.example.retrofit_homework.entity.Article;
import com.example.retrofit_homework.ui.main.mvp.ArticleMVP;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainInteractor implements ArticleMVP.Interactor {
    ArticleService articleService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainInteractor(){
        articleService  = ServiceGenerator.createService(ArticleService.class);
    }
    @Override
    public void LoadArticle(String q, String key, final InteractorResponse<List<Article>> response) {
        //get Article
      compositeDisposable.add(articleService.getArticleWithRx(q,key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableSubscriber<ArticleResponse>() {
                    @Override
                    public void onNext(ArticleResponse articleResponse) {
                        response.onSuccess(articleResponse.getArticles());
                    }

                    @Override
                    public void onError(Throwable t) {
                        response.onError(t.toString());
                    }

                    @Override
                    public void onComplete() {
                        response.onComplete("get article complete");
                    }
                }));
    }
    @Override
    public void onDestory(){
        compositeDisposable.clear();
    }
}

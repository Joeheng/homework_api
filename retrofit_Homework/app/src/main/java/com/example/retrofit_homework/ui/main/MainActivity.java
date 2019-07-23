package com.example.retrofit_homework.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.retrofit_homework.R;
import com.example.retrofit_homework.adapter.AmsAdapter;
import com.example.retrofit_homework.entity.Article;
import com.example.retrofit_homework.ui.main.mvp.ArticleMVP;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleMVP.View {
    AmsAdapter amsAdapter;
    List<Article> articles = new ArrayList<Article>();
    RecyclerView rv;
    private ArticleMVP.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
        initUI();
        getData();

    }

    private void getData() {
        presenter.loadArticle("bitcoin","cf61a7279f864253bec20faeecf40f60");
    }

    private void initUI() {
        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        amsAdapter = new AmsAdapter(articles,this);
        rv.setAdapter(amsAdapter);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void onLoadArticleSuccess(List<Article> articles) {
        amsAdapter.addMoreItems(articles);
        Log.e(TAG, "onLoadArticleSuccess: "+ articles );
    }

    @Override
    public void onError(String message) {
        Log.e(TAG, "onError: "+message );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}

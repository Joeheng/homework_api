package com.example.retrofit_homework.callback;

import com.example.retrofit_homework.entity.Article;

import java.util.List;

public interface InteractorResponse<T> {
    void onSuccess(T dataResponse);
    void onComplete(String message);
    void onError(String error);
}

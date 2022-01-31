package com.example.wilspayoneer.core;

public interface HttpCallback<T> {

    void onSuccess(T success);

    void onError(Throwable error);
}

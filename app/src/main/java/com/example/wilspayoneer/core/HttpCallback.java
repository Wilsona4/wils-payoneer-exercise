package com.example.wilspayoneer.core;

/*
* Interface to listen to Background Thread events
* */
public interface HttpCallback<T> {

    /*Background Task Successfully completed */
    void onSuccess(T success);

    /*Error occurred during background task execution*/
    void onError(BaseException error);
}

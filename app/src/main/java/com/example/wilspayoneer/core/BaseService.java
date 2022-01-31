package com.example.wilspayoneer.core;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BaseService {
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private static BaseService single_instance = null;

    public static BaseService getInstance()
    {
        if (single_instance == null)
            single_instance = new BaseService();

        return single_instance;
    }
}

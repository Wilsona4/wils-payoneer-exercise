package com.example.wilspayoneer.core;

import androidx.test.espresso.idling.CountingIdlingResource;

public class ExpressoIdlingResource {

    private static ExpressoIdlingResource single_instance = null;

    private static final String RESOURCE = "GLOBAL";
    private CountingIdlingResource countingIdlingResource = new CountingIdlingResource(RESOURCE);


    public CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }

    public void setCountingIdlingResource(CountingIdlingResource countingIdlingResource) {
        this.countingIdlingResource = countingIdlingResource;
    }

    public static ExpressoIdlingResource getInstance() {
        if (single_instance == null)
            single_instance = new ExpressoIdlingResource();

        return single_instance;
    }

    public void increment() {
        getCountingIdlingResource().increment();
    }

    public void decrement() {
        getCountingIdlingResource().decrement();
    }

}

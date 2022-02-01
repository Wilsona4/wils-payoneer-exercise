package com.example.wilspayoneer.core;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Utils {

    public static final String PAYMENT_CODE = "PAYMENT CODE";
    public static final String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/listresult.json";


    public static void showError(String string, View view) {
        Snackbar.make(view, string, Snackbar.LENGTH_LONG).show();
    }

    public static void showView(View view) {
        view.setVisibility(View.VISIBLE);
    }

    public static void hideView(View view) {
        view.setVisibility(View.GONE);
    }

}

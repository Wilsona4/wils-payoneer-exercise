package com.example.wilspayoneer.core;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Utils {
//    private static Utils single_instance = null;

    public static final String PAYMENT_CODE = "PAYMENT CODE";

//    public static Utils getInstance() {
//        if (single_instance == null)
//            single_instance = new Utils();
//
//        return single_instance;
//    }

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

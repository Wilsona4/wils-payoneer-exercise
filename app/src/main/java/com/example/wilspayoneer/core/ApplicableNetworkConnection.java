package com.example.wilspayoneer.core;

import com.example.wilspayoneer.data.model.ApplicableItem;
import com.example.wilspayoneer.data.model.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApplicableNetworkConnection extends BaseHttpConnection {

    private final static String BASE_URL = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/listresult.json";

    Gson gson = new GsonBuilder().create();

    public List<ApplicableItem> getApplicableNetworkConnection() throws BaseException {
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = buildUrl(getBaseUrl());

            httpURLConnection = baseGetConnection(url);

            final int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                String jsonString = readStream(httpURLConnection);

                Response response = gson.fromJson(jsonString, Response.class);

                return response.getNetworks().getApplicable();
            }
            throw new BaseException(httpURLConnection.getResponseMessage());

        } catch (IOException e) {
            throw new BaseException(e.getLocalizedMessage());
        } finally {
            assert httpURLConnection != null;
            httpURLConnection.disconnect();
        }
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}

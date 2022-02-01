package com.example.wilspayoneer.core;

import android.net.Uri;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseHttpConnection {

    private final static String GET = "GET";
    private final static int CONNECT_TIMEOUT = 6000;
    private final static int READ_TIMEOUT = 10000;

    /*Build Url URLs from Strings*/
    public URL buildUrl(String requestUrl) throws MalformedURLException {
        if (requestUrl == null) {
            throw new IllegalArgumentException("Url can't be null");
        }

        Uri uri = Uri.parse(requestUrl);
        return new URL(uri.toString());

    }

    /*Base method to create HTTP GET Connection*/
    protected HttpURLConnection baseGetConnection(final URL url) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException("Url can't be null");
        }

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
        urlConnection.setReadTimeout(READ_TIMEOUT);
        urlConnection.setRequestMethod(GET);
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(false);

        return urlConnection;
    }

    /*Create a string from connection stream*/
    protected String readStream(HttpURLConnection urlConnection) throws IOException {
        if (urlConnection == null) {
            throw new IllegalArgumentException("UrlConnection can't be null");
        }

        InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            builder.append(line);
        }
        bufferedReader.close();

        return builder.toString();
    }

}

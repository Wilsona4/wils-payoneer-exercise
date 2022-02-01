package com.example.wilspayoneer.domain;

import static com.example.wilspayoneer.core.ApplicableNetworkConnection.getBaseUrl;

import android.os.Handler;
import android.os.Looper;

import com.example.wilspayoneer.core.BaseException;
import com.example.wilspayoneer.core.BaseHttpConnection;
import com.example.wilspayoneer.core.BaseService;
import com.example.wilspayoneer.core.HttpCallback;
import com.example.wilspayoneer.data.model.ApplicableItem;
import com.example.wilspayoneer.data.model.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RepositoryImpl extends BaseHttpConnection implements IRespository {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Gson gson = new GsonBuilder().create();

    @Override
    public void getApplicableNetworks(HttpCallback<List<ApplicableItem>> httpCallback) {

        BaseService.getInstance().getExecutorService().execute(() -> {
                    HttpURLConnection httpURLConnection = null;
                    try {
                        URL url = buildUrl(getBaseUrl());

                        httpURLConnection = baseGetConnection(url);

                        final int responseCode = httpURLConnection.getResponseCode();

                        if (responseCode == HttpURLConnection.HTTP_OK) {

                            String jsonString = readStream(httpURLConnection);

                            Response response = gson.fromJson(jsonString, Response.class);
                            if (response != null) {
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        httpCallback.onSuccess(response.getNetworks().getApplicable());
                                    }
                                });
                            }
                        } else {
                            throw new BaseException(httpURLConnection.getResponseMessage());
                        }
                    } catch (IOException | BaseException e) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                httpCallback.onError(new BaseException(e.getLocalizedMessage()));
                            }
                        });
                    } finally {
                        assert httpURLConnection != null;
                        httpURLConnection.disconnect();
                    }
                }
        );


//        Future<List<ApplicableItem>> future = BaseService.getInstance().getExecutorService().submit(new Callable<List<ApplicableItem>>() {
//            @Override
//            public List<ApplicableItem> call() throws BaseException {
//                return applicableNetworkConnection.getApplicableNetworkConnection();
//            }
//        });
//
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if (httpCallback != null) {
//                    try {
//                        httpCallback.onSuccess(future.get());
//                    } catch (ExecutionException | InterruptedException e) {
//                        httpCallback.onError(new BaseException(e.getMessage()));
//                    }
//                }
//            }
//        });


    }
}

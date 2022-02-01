package com.example.wilspayoneer.domain;

import com.example.wilspayoneer.core.HttpCallback;
import com.example.wilspayoneer.data.model.ApplicableItem;

import java.util.List;

public interface IRespository {
    public void getApplicableNetworks(HttpCallback<List<ApplicableItem>> httpCallback);
}

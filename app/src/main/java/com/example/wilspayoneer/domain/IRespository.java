package com.example.wilspayoneer.domain;

import com.example.wilspayoneer.data.model.ApplicableItem;

import java.util.List;

public interface IRespository {
    public List<ApplicableItem> getApplicableNetworks();
}

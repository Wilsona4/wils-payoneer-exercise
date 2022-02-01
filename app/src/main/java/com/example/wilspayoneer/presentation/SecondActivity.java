package com.example.wilspayoneer.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wilspayoneer.core.Utils;
import com.example.wilspayoneer.data.model.ApplicableItem;
import com.example.wilspayoneer.data.model.InputElementsItem;
import com.example.wilspayoneer.databinding.ActivitySecondBinding;
import com.example.wilspayoneer.presentation.adapter.CustomAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    private List<InputElementsItem> inputElementsItemList = new ArrayList<>();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getInputItemList();

        initRecyclerView();
    }

    /*Set-Up Recycler View*/
    private void initRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) binding.rvInputElements;
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        CustomAdapter mAdapter = new CustomAdapter(inputElementsItemList);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
    }

    /*Retrieve Input Item List*/
    private void getInputItemList() {
        String applicableItemJson = getIntent().getStringExtra(Utils.PAYMENT_CODE);
        ApplicableItem applicableItem = gson.fromJson(applicableItemJson, ApplicableItem.class);
        binding.tvCodeName.setText(applicableItem.getLabel());

        if (applicableItem.getInputElements() != null) {
            inputElementsItemList = applicableItem.getInputElements();
            Utils.hideView(binding.tvNotice);
        } else {
            Utils.showView(binding.tvNotice);
        }
    }
}
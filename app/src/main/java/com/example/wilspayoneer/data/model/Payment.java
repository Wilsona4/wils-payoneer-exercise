package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Payment{

	@SerializedName("reference")
	private String reference;

	@SerializedName("amount")
	private int amount;

	@SerializedName("currency")
	private String currency;

	public String getReference(){
		return reference;
	}

	public int getAmount(){
		return amount;
	}

	public String getCurrency(){
		return currency;
	}
}
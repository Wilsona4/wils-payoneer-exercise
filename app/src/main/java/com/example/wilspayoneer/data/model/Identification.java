package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Identification{

	@SerializedName("shortId")
	private String shortId;

	@SerializedName("longId")
	private String longId;

	@SerializedName("transactionId")
	private String transactionId;

	public String getShortId(){
		return shortId;
	}

	public String getLongId(){
		return longId;
	}

	public String getTransactionId(){
		return transactionId;
	}
}
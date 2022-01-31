package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("reason")
	private String reason;

	@SerializedName("code")
	private String code;

	public String getReason(){
		return reason;
	}

	public String getCode(){
		return code;
	}
}
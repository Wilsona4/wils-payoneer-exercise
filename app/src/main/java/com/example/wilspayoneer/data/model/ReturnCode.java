package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class ReturnCode{

	@SerializedName("name")
	private String name;

	@SerializedName("source")
	private String source;

	public String getName(){
		return name;
	}

	public String getSource(){
		return source;
	}
}
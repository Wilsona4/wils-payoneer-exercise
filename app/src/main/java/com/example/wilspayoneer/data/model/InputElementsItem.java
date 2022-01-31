package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class InputElementsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("type")
	private String type;

	public String getName(){
		return name;
	}

	public String getType(){
		return type;
	}
}
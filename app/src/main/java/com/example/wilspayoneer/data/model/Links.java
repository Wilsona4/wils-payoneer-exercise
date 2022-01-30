package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("logo")
	private String logo;

	@SerializedName("self")
	private String self;

	@SerializedName("lang")
	private String lang;

	@SerializedName("operation")
	private String operation;

	@SerializedName("validation")
	private String validation;

	public String getLogo(){
		return logo;
	}

	public String getSelf(){
		return self;
	}

	public String getLang(){
		return lang;
	}

	public String getOperation(){
		return operation;
	}

	public String getValidation(){
		return validation;
	}
}
package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("self")
	private String self;

	@SerializedName("lang")
	private String lang;

	@SerializedName("logo")
	private String logo;

	@SerializedName("operation")
	private String operation;

	@SerializedName("validation")
	private String validation;

	public String getSelf(){
		return self;
	}

	public String getLang(){
		return lang;
	}

	public String getLogo(){
		return logo;
	}

	public String getOperation(){
		return operation;
	}

	public String getValidation(){
		return validation;
	}
}
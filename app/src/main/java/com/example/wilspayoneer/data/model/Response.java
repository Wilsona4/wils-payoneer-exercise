package com.example.wilspayoneer.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("applicable")
	private List<Applicable> applicable;

	public List<Applicable> getApplicable(){
		return applicable;
	}
}
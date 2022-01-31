package com.example.wilspayoneer.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Networks{

	@SerializedName("applicable")
	private List<ApplicableItem> applicable;

	public List<ApplicableItem> getApplicable(){
		return applicable;
	}
}
package com.example.wilspayoneer.data.model;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("resultCode")
	private String resultCode;

	@SerializedName("networks")
	private Networks networks;

	@SerializedName("resultInfo")
	private String resultInfo;

	@SerializedName("returnCode")
	private ReturnCode returnCode;

	@SerializedName("identification")
	private Identification identification;

	@SerializedName("integrationType")
	private String integrationType;

	@SerializedName("interaction")
	private Interaction interaction;

	@SerializedName("links")
	private Links links;

	@SerializedName("operationType")
	private String operationType;

	@SerializedName("style")
	private Style style;

	@SerializedName("payment")
	private Payment payment;

	@SerializedName("operation")
	private String operation;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("status")
	private Status status;

	public String getResultCode(){
		return resultCode;
	}

	public Networks getNetworks(){
		return networks;
	}

	public String getResultInfo(){
		return resultInfo;
	}

	public ReturnCode getReturnCode(){
		return returnCode;
	}

	public Identification getIdentification(){
		return identification;
	}

	public String getIntegrationType(){
		return integrationType;
	}

	public Interaction getInteraction(){
		return interaction;
	}

	public Links getLinks(){
		return links;
	}

	public String getOperationType(){
		return operationType;
	}

	public Style getStyle(){
		return style;
	}

	public Payment getPayment(){
		return payment;
	}

	public String getOperation(){
		return operation;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public Status getStatus(){
		return status;
	}
}
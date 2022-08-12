package com.example.moneytransfer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
public class ConfirmOperationInDto {

	@NotNull
	String operationId;

	@NotNull
	String code;

	@Builder
	@JsonCreator
	public ConfirmOperationInDto(@JsonProperty("operationId") String operationId,
								 @JsonProperty("code") String code ){
		this.operationId = operationId;
		this.code = code;
	}

}

package com.example.moneytransfer.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
public class TransferOutDto {
	private String operationId;

	@Builder
	@JsonCreator
	public TransferOutDto(@JsonProperty("operationId") String operationId){
		this.operationId = operationId;
	}

}

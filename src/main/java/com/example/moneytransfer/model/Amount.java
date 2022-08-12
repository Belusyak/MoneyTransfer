package com.example.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
public class Amount {

	Long value;

	String currency;

	@Builder
	@JsonCreator
	public Amount(@JsonProperty("value") Long value,
				  @JsonProperty("currency") String currency) {
		this.currency = currency;
		this.value = value;
	}

}

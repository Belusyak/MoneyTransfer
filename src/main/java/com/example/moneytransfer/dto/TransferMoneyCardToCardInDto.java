package com.example.moneytransfer.dto;

import com.example.moneytransfer.model.Amount;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
public class TransferMoneyCardToCardInDto {

	@NotNull
	String cardFromNumber;

	@NotNull
	String cardFromValidTill;

	@NotNull
	String cardFromCVV;

	@NotNull
	String cardToNumber;

	@NotNull
	Amount amount;

	@Builder
	@JsonCreator
	public TransferMoneyCardToCardInDto(@JsonProperty("cardFromNumber") String cardFromNumber,
										@JsonProperty("cardFromValidTill") String cardFromValidTill,
										@JsonProperty("cardFromCVV") String cardFromCVV,
										@JsonProperty("cardToNumber") String cardToNumber,
										@JsonProperty("amount") Amount amount) {
		this.cardFromNumber = cardFromNumber;
		this.cardFromValidTill = cardFromValidTill;
		this.cardFromCVV = cardFromCVV;
		this.cardToNumber = cardToNumber;
		this.amount = amount;
	}

}

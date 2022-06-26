package com.example.moneytransfer.dto;

import com.example.moneytransfer.model.Amount;
import com.sun.istack.NotNull;
import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
public class TransferMoneyCardToCardInDto {

	@NotNull
	@Pattern(regexp = "\\d{16}")
	String cardFromNumber;

	@NotNull
	@Pattern(regexp = "(0[1-9]|1[0-2])[0-9][0-9]")
	String cardFromValidTill;

	@NotNull
	@Pattern(regexp = "\\d{3}")
	String cardFromCVV;

	@NotNull
	@Pattern(regexp = "\\d{16}")
	String cardToNumber;

	Amount amount;

}

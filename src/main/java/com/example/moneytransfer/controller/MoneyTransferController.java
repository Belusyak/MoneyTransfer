package com.example.moneytransfer.controller;

import com.example.moneytransfer.dto.ConfirmOperationInDto;
import com.example.moneytransfer.dto.TransferMoneyCardToCardInDto;
import com.example.moneytransfer.dto.TransferOutDto;
import com.example.moneytransfer.service.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MoneyTransferController {

	private final MoneyTransferService moneyTransferService;

	@PostMapping("/transfer")
	public TransferOutDto transferMoneyCardToCard(@RequestBody @Valid TransferMoneyCardToCardInDto dto) {
		return moneyTransferService.transferMoneyCardToCard(dto);
	}

	@PostMapping("/confirmOperation")
	public String confirmOperation(@RequestBody ConfirmOperationInDto dto) {
		return moneyTransferService.confirmOperation(dto);
	}

}

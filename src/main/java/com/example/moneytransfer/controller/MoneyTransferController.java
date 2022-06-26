package com.example.moneytransfer.controller;

import com.example.moneytransfer.dto.TransferMoneyCardToCardInDto;
import com.example.moneytransfer.dto.TransferOutDto;
import com.example.moneytransfer.service.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoneyTransferController {

	private final MoneyTransferService moneyTransferService;

	@PostMapping(value = "/tranfer")
	public TransferOutDto transferMoneyCardToCard(@RequestBody TransferMoneyCardToCardInDto dto) {
		return moneyTransferService.transferMoneyCardToCard(dto);
	}

}

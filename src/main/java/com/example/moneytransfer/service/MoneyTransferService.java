package com.example.moneytransfer.service;

import com.example.moneytransfer.dao.BankCardDao;
import com.example.moneytransfer.dao.TransferOperationDao;
import com.example.moneytransfer.dto.TransferMoneyCardToCardInDto;
import com.example.moneytransfer.dto.TransferOutDto;
import com.example.moneytransfer.model.BankCard;
import com.example.moneytransfer.model.TransferOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@AllArgsConstructor
public class MoneyTransferService {

	private final BankCardDao bankCardDao;
	private final TransferOperationDao transferOperationDao;

	public TransferOutDto transferMoneyCardToCard(TransferMoneyCardToCardInDto dto) {
		BankCard bankCardFrom = bankCardDao.findByNumber(dto.getCardFromNumber())
				.orElseThrow();

		BankCard bankCardTo = bankCardDao.findByNumber(dto.getCardToNumber())
				.orElseThrow();

		return TransferOutDto.builder().build();
	}

	private void saveOperation(TransferMoneyCardToCardInDto dto, String codeResult) {
		TransferOperation transferOperation = new TransferOperation();
		transferOperation.setCardFromNumber(dto.getCardFromNumber());
		transferOperation.setCardToNumber(dto.getCardToNumber());
		transferOperation.setAmount(dto.getAmount().getValue());
		transferOperation.setCurrency(dto.getAmount().getCurrency());
		transferOperation.setLocalDateTime(LocalDateTime.now());
		transferOperation.setResult(codeResult);

		transferOperationDao.save(transferOperation);
	}

	private void logOperation(){

	}

}

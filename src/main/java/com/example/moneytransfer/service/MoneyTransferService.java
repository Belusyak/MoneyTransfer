package com.example.moneytransfer.service;

import com.example.moneytransfer.dao.BankCardDao;
import com.example.moneytransfer.dao.TransferOperationDao;
import com.example.moneytransfer.dto.ConfirmOperationInDto;
import com.example.moneytransfer.dto.TransferMoneyCardToCardInDto;
import com.example.moneytransfer.dto.TransferOutDto;
import com.example.moneytransfer.exception.NotEnoughMoneyException;
import com.example.moneytransfer.exception.NotFoundEntityException;
import com.example.moneytransfer.model.BankCard;
import com.example.moneytransfer.model.CodeResult;
import com.example.moneytransfer.model.TransferOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class MoneyTransferService {

	private final BankCardDao bankCardDao;
	private final TransferOperationDao transferOperationDao;

	@Transactional
	public TransferOutDto transferMoneyCardToCard(TransferMoneyCardToCardInDto dto) {
		CodeResult codeResult = CodeResult.IN_PROGRESS;
		Long amount = dto.getAmount().getValue();

		bankCardDao.findByNumber(dto.getCardFromNumber())
				.orElseThrow(() -> new NotFoundEntityException("cardFrom not found"));
		bankCardDao.findByNumber(dto.getCardToNumber())
				.orElseThrow(() -> new NotFoundEntityException("cardTo not found"));

		String operationId = saveOperation(dto, codeResult);
		return new TransferOutDto(operationId);
	}

	@Transactional
	public String confirmOperation(ConfirmOperationInDto dto) {
		TransferOperation transferOperation = transferOperationDao.findById(Long.parseLong(dto.getOperationId()))
				.orElseThrow(() -> new NotFoundEntityException("transferOperation not found"));
		BankCard bankCardFrom = bankCardDao.findByNumber(transferOperation.getCardFromNumber())
				.orElseThrow(() -> new NotFoundEntityException("cardFrom not found"));
		BankCard bankCardTo = bankCardDao.findByNumber(transferOperation.getCardToNumber())
				.orElseThrow(() -> new NotFoundEntityException("cardTo not found"));

		Long amount = transferOperation.getAmount();

		if (bankCardFrom.getBalance() < amount) {
			transferOperation.setResult(CodeResult.NOT_ENOUGH_MONEY);
			transferOperationDao.save(transferOperation);
			throw new NotEnoughMoneyException("Not enough money");
		}

		bankCardFrom.setBalance(bankCardFrom.getBalance() - amount);
		bankCardTo.setBalance(bankCardTo.getBalance() + amount);

		transferOperation.setResult(CodeResult.OK);
		transferOperationDao.save(transferOperation);
		return "OK";
	}

	private String saveOperation(TransferMoneyCardToCardInDto dto, CodeResult codeResult) {
		TransferOperation transferOperation = new TransferOperation();
		transferOperation.setCardFromNumber(dto.getCardFromNumber());
		transferOperation.setCardToNumber(dto.getCardToNumber());
		transferOperation.setAmount(dto.getAmount().getValue());
		transferOperation.setCurrency(dto.getAmount().getCurrency());
		transferOperation.setResult(codeResult);

		transferOperationDao.save(transferOperation);
		return transferOperation.getId().toString();
	}

}

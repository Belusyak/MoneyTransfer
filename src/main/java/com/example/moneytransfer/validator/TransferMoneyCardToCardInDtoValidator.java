package com.example.moneytransfer.validator;

import com.example.moneytransfer.dto.TransferMoneyCardToCardInDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class TransferMoneyCardToCardInDtoValidator implements Validator {

	private static final int CARD_NUMBER_LENGTH = 16;
	private static final int CVV_LENGTH = 16;

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		TransferMoneyCardToCardInDto dto = (TransferMoneyCardToCardInDto) target;

		if (dto.getCardFromNumber().length() != CARD_NUMBER_LENGTH) {
			errors.reject(null, "Номер карты отправителя должен быть 16 символов");
		}

		if (dto.getCardToNumber().length() != CARD_NUMBER_LENGTH) {
			errors.reject(null, "Номер карты получателя должен быть 16 символов");
		}

		if (dto.getCardFromCVV().length() != CVV_LENGTH) {
			errors.reject(null, "CVC / CVC2 код отправителя должен быть 3 символа");
		}

		String validTill = dto.getCardFromValidTill();

		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		int currentMonth = currentDate.getMonthValue();

		int month = Integer.parseInt(validTill.substring(0, 2));
		int year = Integer.parseInt("20" + validTill.substring(2));

		if (month > 12) {
			errors.reject(null, "Текущий месяц не может быть больше 12");
		}

		if (year < currentYear) {
			if (month < currentMonth) {
				errors.reject(null, "Истекла дата действия карты отправителя");
			}
		}
	}
}

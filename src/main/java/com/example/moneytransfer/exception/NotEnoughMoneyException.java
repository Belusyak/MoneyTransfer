package com.example.moneytransfer.exception;

public class NotEnoughMoneyException extends RuntimeException {
	public NotEnoughMoneyException(String message) {
		super(message);
	}
}

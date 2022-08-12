package com.example.moneytransfer.exception;

public class NotFoundEntityException extends RuntimeException {
	public NotFoundEntityException(String message) {
		super(message);
	}
}

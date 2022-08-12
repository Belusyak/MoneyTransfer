package com.example.moneytransfer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "t_transfer_operation")
public class TransferOperation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime localDateTime = LocalDateTime.now();

	@Column(nullable = false)
	private String cardFromNumber;

	@Column(nullable = false)
	private String cardToNumber;

	@Column(nullable = false)
	private Long amount;

	@Column(nullable = false)
	private String currency;

	@Column(nullable = false)
	private Long commission;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CodeResult result;
}

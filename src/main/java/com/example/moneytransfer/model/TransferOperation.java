package com.example.moneytransfer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@Column
	LocalDateTime localDateTime;

	@Column
	String cardFromNumber;

	@Column
	String cardToNumber;

	@Column
	Long amount;

	@Column
	String currency;

	@Column
	Long commission;

	@Column
	String result;
}

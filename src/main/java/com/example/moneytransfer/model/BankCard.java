package com.example.moneytransfer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "t_bank_card")
public class BankCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long balance;

	@Column(nullable = false)
	private String number;

	@Column(name = "valid_till", nullable = false)
	private String validTill;

	@Column(name = "cvv", nullable = false)
	private String CVV;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;
}

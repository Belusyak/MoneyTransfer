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

	@Column
	private int balance;

	@Column
	private String number;

	@Column(name = "valid_till")
	private String validTill;

	@Column(name = "cvv")
	private String CVV;

	@Column
	private String name;

	@Column
	private String surname;
}

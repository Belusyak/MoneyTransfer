package com.example.moneytransfer.dao;

import com.example.moneytransfer.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankCardDao extends JpaRepository<BankCard, Long> {

	Optional<BankCard> findByNumber(String number);
}

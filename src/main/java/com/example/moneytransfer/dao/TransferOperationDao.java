package com.example.moneytransfer.dao;

import com.example.moneytransfer.model.TransferOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferOperationDao extends JpaRepository<TransferOperation,Long> {
}

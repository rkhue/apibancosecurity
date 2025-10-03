package com.apibancosecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apibancosecurity.model.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}

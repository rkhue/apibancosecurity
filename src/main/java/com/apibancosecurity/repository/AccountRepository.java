package com.apibancosecurity.repository;

import com.apibancosecurity.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByDocument(String document);
}

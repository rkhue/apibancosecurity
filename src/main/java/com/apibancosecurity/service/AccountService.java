package com.apibancosecurity.service;

import com.apibancosecurity.dto.mapper.AccountMapper;
import com.apibancosecurity.dto.schemas.AccountRequestDTO;
import com.apibancosecurity.dto.schemas.AccountResponseDTO;
import com.apibancosecurity.model.Account;
import com.apibancosecurity.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional
    public AccountResponseDTO createAccount(AccountRequestDTO accountRequestDTO) {
        Account account = accountMapper.toModel(accountRequestDTO);
        accountRepository.save(account);
        return accountMapper.toResponse(account);
    }

    Account getById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Account with id %d not found", id)));
    }
    public AccountResponseDTO getAccountById(Long id) {
        return accountMapper.toResponse(getById(id));
    }

    public List<AccountResponseDTO> getAllAccounts() {
        return accountMapper.toResponseList(accountRepository.findAll());
    }
}

package com.apibancosecurity.controller;

import com.apibancosecurity.dto.schemas.AccountRequestDTO;
import com.apibancosecurity.dto.schemas.AccountResponseDTO;
import com.apibancosecurity.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponseDTO get(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponseDTO> getAll() {
        return accountService.getAllAccounts();
    }
}

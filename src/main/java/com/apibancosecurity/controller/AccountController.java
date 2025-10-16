package com.apibancosecurity.controller;

import com.apibancosecurity.dto.schemas.AccountRequestDTO;
import com.apibancosecurity.dto.schemas.AccountResponseDTO;
import com.apibancosecurity.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponseDTO get(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponseDTO> getAll() {
        return accountService.getAllAccounts();
    }
}

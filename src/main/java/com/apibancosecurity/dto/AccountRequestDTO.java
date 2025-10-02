package com.apibancosecurity.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public class AccountRequestDTO {

    @NotBlank
    private String document; // CPF/CNPJ simplificado

    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal balance = BigDecimal.ZERO;

    public AccountRequestDTO() {
    }

    public AccountRequestDTO(String document, String name, BigDecimal balance) {
        this.document = document;
        this.name = name;
        this.balance = balance;
    }

    // getters/setters
    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

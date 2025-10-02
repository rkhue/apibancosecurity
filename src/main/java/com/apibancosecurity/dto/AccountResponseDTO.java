package com.apibancosecurity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class AccountResponseDTO {
    private Long id;
    private String document; // CPF/CNPJ simplificado
    private String name;
    private BigDecimal balance = BigDecimal.ZERO;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(Long id, String document, String name, BigDecimal balance) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.balance = balance;
    }

    // getters/setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

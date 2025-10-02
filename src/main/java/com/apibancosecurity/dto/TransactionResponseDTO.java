package com.apibancosecurity.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

public class TransactionResponseDTO {

    private Long id;
    private Long from;
    private Long to;
    private BigDecimal amount;
    private OffsetDateTime createdAt;

    public TransactionResponseDTO() {
    }

    public TransactionResponseDTO(Long id, Long from, Long to, BigDecimal amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    // getters/setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

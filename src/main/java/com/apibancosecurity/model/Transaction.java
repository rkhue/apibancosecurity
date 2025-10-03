package com.apibancosecurity.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {
    // getters/setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account from;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account to;

    private BigDecimal amount;

    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now();
}


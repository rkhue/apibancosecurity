package com.apibancosecurity.dto.schemas;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDTO {
    private Long id;
    private Long from;
    private Long to;
    private BigDecimal amount;
    private OffsetDateTime createdAt;
}

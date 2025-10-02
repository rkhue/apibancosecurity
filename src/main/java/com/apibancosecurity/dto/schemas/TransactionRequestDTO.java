package com.apibancosecurity.dto.schemas;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {
    @NotNull
    private Long from;

    @NotNull
    private Long to;

    @NotNull
    @Positive
    private BigDecimal amount;
}

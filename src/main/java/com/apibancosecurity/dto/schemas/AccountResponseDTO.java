package com.apibancosecurity.dto.schemas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDTO {
    private Long id;
    private String document; // CPF/CNPJ simplificado
    private String name;

    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;
}

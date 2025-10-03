package com.apibancosecurity.dto.schemas;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestDTO {

    @NotBlank
    private String document; // CPF/CNPJ simplificado

    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;
}

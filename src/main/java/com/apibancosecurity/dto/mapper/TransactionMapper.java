package com.apibancosecurity.dto.mapper;

import com.apibancosecurity.dto.mapper.base.BaseMapper;
import com.apibancosecurity.dto.schemas.TransactionRequestDTO;
import com.apibancosecurity.dto.schemas.TransactionResponseDTO;
import com.apibancosecurity.model.Account;
import com.apibancosecurity.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper extends BaseMapper<Transaction, TransactionRequestDTO, TransactionResponseDTO> {

    @Override
    public TransactionResponseDTO toResponse(Transaction model) {
        return TransactionResponseDTO.builder()
                .id(model.getId())
                .to(model.getTo().getId())
                .from(model.getFrom().getId())
                .amount(model.getAmount())
                .createdAt(model.getCreatedAt())
                .build();
    }

    @Override
    @Deprecated
    public Transaction toModel(TransactionRequestDTO request) {
        throw new UnsupportedOperationException("not implemented");
    }

    public Transaction toModel(TransactionRequestDTO request, Account from, Account to) {
        return Transaction.builder()
                .from(from)
                .to(to)
                .amount(request.getAmount())
                .build();
    }
}
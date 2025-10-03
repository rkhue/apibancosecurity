package com.apibancosecurity.service;

import com.apibancosecurity.dto.mapper.TransactionMapper;
import com.apibancosecurity.dto.schemas.TransactionRequestDTO;
import com.apibancosecurity.dto.schemas.TransactionResponseDTO;
import com.apibancosecurity.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public TransactionService(TransactionMapper transactionMapper, TransactionRepository transactionRepository, AccountService accountService) {
        this.transactionMapper = transactionMapper;
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
    }

    @Transactional
    public TransactionResponseDTO createTransaction(TransactionRequestDTO transactionRequestDTO) {
        return transactionMapper.toResponse(
                transactionRepository.save(
                        transactionMapper.toModel(
                                transactionRequestDTO,
                                accountService.getById(transactionRequestDTO.getFrom()),
                                accountService.getById(transactionRequestDTO.getTo())
                        )
                )
        );
    }

    public TransactionResponseDTO getTransactionById(Long id) {
        return transactionMapper.toResponse(
                transactionRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException(String.format("Transaction with id %d not found", id)))
        );
    }

    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionMapper.toResponseList(transactionRepository.findAll());
    }
}

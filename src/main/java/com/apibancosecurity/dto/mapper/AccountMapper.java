package com.apibancosecurity.dto.mapper;

import com.apibancosecurity.dto.mapper.base.BaseMapper;
import com.apibancosecurity.dto.schemas.AccountRequestDTO;
import com.apibancosecurity.dto.schemas.AccountResponseDTO;
import com.apibancosecurity.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper extends BaseMapper<Account, AccountRequestDTO, AccountResponseDTO> {

    @Override
    public AccountResponseDTO toResponse(Account model) {
        return AccountResponseDTO.builder()
                .id(model.getId())
                .document(model.getDocument())
                .name(model.getName())
                .balance(model.getBalance())
                .build();
    }

    @Override
    public Account toModel(AccountRequestDTO request) {
        return Account.builder()
                .name(request.getName())
                .document(request.getDocument())
                .balance(request.getBalance())
                .build();
    }
}

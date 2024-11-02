package org.sid.bankaccountservice1.service;

import  org.sid.bankaccountservice1.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice1.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice1.entities.BankAccount;
import org.sid.bankaccountservice1.mappers.AccountMapper;
import org.sid.bankaccountservice1.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();


BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
 BankAccountResponseDTO bankAccountResponseDTO=accountMapper.frombankAccount(saveBankAccount);

        return bankAccountResponseDTO;
    }
    @Override
    public BankAccountResponseDTO updateAccount( String id ,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();


        BankAccount saveBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.frombankAccount(saveBankAccount);

        return bankAccountResponseDTO;
    }
}

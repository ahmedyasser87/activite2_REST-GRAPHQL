package org.sid.bankaccountservice1.service;

import org.sid.bankaccountservice1.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice1.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice1.entities.BankAccount;
import org.sid.bankaccountservice1.enums.AccountType;

public interface BankAccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);


}


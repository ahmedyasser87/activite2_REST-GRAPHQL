package org.sid.bankaccountservice1.mappers;

import org.sid.bankaccountservice1.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice1.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO frombankAccount (BankAccount bankAccount)
    {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;

    }
}

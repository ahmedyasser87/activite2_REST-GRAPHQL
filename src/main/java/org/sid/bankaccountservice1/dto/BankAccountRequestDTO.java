package org.sid.bankaccountservice1.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice1.enums.AccountType;

import java.util.Date;
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {


    private Double balance;
    private String currency;

    private AccountType type;
}

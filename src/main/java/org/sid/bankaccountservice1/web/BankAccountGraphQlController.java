package org.sid.bankaccountservice1.web;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bankaccountservice1.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice1.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice1.entities.BankAccount;
import org.sid.bankaccountservice1.entities.Customer;
import org.sid.bankaccountservice1.enums.AccountType;
import org.sid.bankaccountservice1.repositories.BankAccountRepository;
import org.sid.bankaccountservice1.repositories.CustomerRepository;
import org.sid.bankaccountservice1.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList()
    {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountByID( @Argument  String id )
    {
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found ",id)));

    }
    @MutationMapping
    public BankAccountResponseDTO addAccount (@Argument BankAccountRequestDTO bankAccount)
    {
       return bankAccountService.addAccount(bankAccount);

    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount ( @Argument String id , @Argument BankAccountRequestDTO bankAccount)
    {
        return bankAccountService.updateAccount(id, bankAccount);

    }
    @MutationMapping
    public boolean deleteAccount ( @Argument String id)
    {
       bankAccountRepository.deleteById(id);
       return true;

    }
    @QueryMapping
     public List<Customer> customers ( )
     {
         return customerRepository.findAll();

     }


   /* record BankAccountDTO (String type , Double balance , String currency )*/

}

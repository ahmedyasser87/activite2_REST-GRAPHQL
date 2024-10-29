package org.sid.bankaccountservice1;

import org.sid.bankaccountservice1.entities.BankAccount;
import org.sid.bankaccountservice1.enums.AccountType;
import org.sid.bankaccountservice1.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountService1Application {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountService1Application.class, args);
    }
  @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository)
  {
      return args -> {
          for (int i=0;i<10;i++)
          {
              BankAccount bankAccount= BankAccount.builder()
                      .id(UUID.randomUUID().toString())
                      .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                      .balance(1000+Math.random()*90000)
                      .createdAt(new Date())
                      .currency("MAD")
                      .build();
              bankAccountRepository.save(bankAccount);

          }
      };
  }
}

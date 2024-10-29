package org.sid.bankaccountservice1.web;

import org.sid.bankaccountservice1.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice1.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice1.entities.BankAccount;
import org.sid.bankaccountservice1.mappers.AccountMapper;
import org.sid.bankaccountservice1.repositories.BankAccountRepository;
import org.sid.bankaccountservice1.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestContoler {

    public AccountRestContoler(BankAccountRepository bankAccountRepository, BankAccountService bankAccountService,   AccountMapper accountMapper ) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountService=bankAccountService;
        this.accountMapper=accountMapper;
    }

    private BankAccountRepository bankAccountRepository ;
    private BankAccountService bankAccountService;
    private AccountMapper accountMapper;
     @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts()
   {
       return bankAccountRepository.findAll();
   }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id)
    {
        return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("account %S NOT FOUND ",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO requestDTO)
    {

        return bankAccountService.addAccount(requestDTO);

    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update ( @PathVariable String id , @RequestBody BankAccount bankAccount)
    {
        BankAccount account= bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        if (bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);

    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount (@PathVariable String id)
    {
       bankAccountRepository.deleteById(id);
    }
}

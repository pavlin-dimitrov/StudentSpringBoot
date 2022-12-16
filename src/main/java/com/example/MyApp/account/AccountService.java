package com.example.MyApp.account;

import com.example.MyApp.student.Student;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

  @Autowired
  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void addNewAccount(Account account) {
    Optional<Account> accountByEmail = accountRepository.findAccountByEmail(account.getEmail());
    if (accountByEmail.isPresent()) {
      throw new IllegalStateException("Email is taken! Use another e-mail address!");
    }
    accountRepository.save(account);
  }

  public Optional<Account> getAccountById(Long id) {
    return accountRepository.findAccountById(id);
  }

}

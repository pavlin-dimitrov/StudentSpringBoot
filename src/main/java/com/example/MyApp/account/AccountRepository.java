package com.example.MyApp.account;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

  Optional<Account> findAccountByEmail(String email);

  Optional<Account> findAccountById(Long id);
}

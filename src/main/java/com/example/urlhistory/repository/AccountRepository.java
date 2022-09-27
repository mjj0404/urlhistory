package com.example.urlhistory.repository;

import com.example.urlhistory.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

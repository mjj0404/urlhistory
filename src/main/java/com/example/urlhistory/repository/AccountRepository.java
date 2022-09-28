package com.example.urlhistory.repository;

import com.example.urlhistory.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM account a WHERE a.account_name IN :names", nativeQuery = true)
    List<Account> findAccountByName(@Param("names") Set<String> names);
}

package com.example.urlhistory.repository;

import com.example.urlhistory.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface AccountRepository extends JpaRepository<Account, Long> {
//    @Query("SELECT l1 FROM Location l1 WHERE l1.node.id IN :ids")
//    List<Location> findLocationsByNodeIds(@Param("ids") Set<String> ids);
    @Query(value = "SELECT * FROM account a WHERE a.first_name IN :names or a.last_name IN :names", nativeQuery = true)
    List<Account> findAccountByName(@Param("names") Set<String> names);
}

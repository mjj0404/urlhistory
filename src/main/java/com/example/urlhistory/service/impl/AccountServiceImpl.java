package com.example.urlhistory.service.impl;

import com.example.urlhistory.exception.ResourceConflictException;
import com.example.urlhistory.exception.ResourceNotFoundException;
import com.example.urlhistory.model.Account;
import com.example.urlhistory.repository.AccountRepository;
import com.example.urlhistory.service.AccountService;
import jakarta.persistence.EntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        super();
        this.accountRepository = accountRepository;
    }


    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountListByName(Set<String> nameSet) {
        return accountRepository.findAccountByName(nameSet);
    }

}

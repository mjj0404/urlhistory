package com.example.urlhistory.service.impl;

import com.example.urlhistory.model.Account;
import com.example.urlhistory.repository.AccountRepository;
import com.example.urlhistory.service.AccountService;
import org.springframework.stereotype.Service;

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
}

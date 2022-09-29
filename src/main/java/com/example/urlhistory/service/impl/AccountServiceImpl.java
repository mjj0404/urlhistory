package com.example.urlhistory.service.impl;

import com.example.urlhistory.UrlhistoryConfig;
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
import java.util.Optional;
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
        account.setStorageDurationInDays(account.getStorageDurationInDays() == null ? 7L : account.getStorageDurationInDays());
        account.setUrlCount(account.getUrlCount() == null ? 0L : account.getUrlCount());
        account.setUrlMaxCount(account.getUrlMaxCount() == null ? 100L : account.getUrlMaxCount());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountListByName(Set<String> nameSet) {
        return accountRepository.findAccountByNameSet(nameSet);
    }

    @Override
    public Account updateAccount(Account account) {
        Optional<Account> existingAccount = accountRepository.findAccountByName(account.getAccountName());
        if (existingAccount.isPresent()) {
            accountRepository.save(account);

            return existingAccount.get();
        }
        else {
            throw new ResourceNotFoundException("User", "Name", account.getAccountName());
        }
    }

}

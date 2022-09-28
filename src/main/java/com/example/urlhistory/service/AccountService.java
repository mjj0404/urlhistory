package com.example.urlhistory.service;

import com.example.urlhistory.model.Account;

import java.util.List;
import java.util.Set;

public interface AccountService {
    Account saveAccount(Account account);
    List<Account> getAccountList();
    List<Account> getAccountListByName(Set<String> nameSet);
}

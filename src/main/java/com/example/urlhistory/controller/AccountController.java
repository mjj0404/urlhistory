package com.example.urlhistory.controller;

import com.example.urlhistory.model.Account;
import com.example.urlhistory.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        super();
        this.accountService = accountService;
    }

    @PostMapping()
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED);
    }
}

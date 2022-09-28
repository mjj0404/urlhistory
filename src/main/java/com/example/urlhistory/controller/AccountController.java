package com.example.urlhistory.controller;

import com.example.urlhistory.model.Account;
import com.example.urlhistory.model.UserWrapper;
import com.example.urlhistory.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @GetMapping()
    public ResponseEntity<List<Account>> getAccountListByName(@RequestBody(required = false) UserWrapper userWrapper) {
        Set<String> set = new HashSet<>();
        if (userWrapper != null) {
            System.out.println(userWrapper.getUsers().toString());
            set.addAll(userWrapper.getUsers());
        }
        if (set.isEmpty()) return new ResponseEntity<List<Account>>(accountService.getAccountList(), HttpStatus.OK);
        else return new ResponseEntity<List<Account>>(accountService.getAccountListByName(set), HttpStatus.OK);
//        if (set.isEmpty()) return accountService.getAccountList();
//        else return accountService.getAccountListByName(set);
    }
}

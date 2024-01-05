package com.example.hearthstone.controller;

import com.example.hearthstone.entity.Account;
import com.example.hearthstone.model.HttpResponse;
import com.example.hearthstone.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Account> accounts = accountService.findAll();
        return accounts;
    }
}

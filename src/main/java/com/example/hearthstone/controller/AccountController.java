package com.example.hearthstone.controller;

import com.example.hearthstone.entity.Account;
import com.example.hearthstone.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public Page<Account> getAllAccounts(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return accountService.findAll(pageable);
    }

    @PostMapping("/accounts")
    public Account CreateAccount(
            @RequestParam("account") String account,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("gold") int gold,
            @RequestParam("dust") int dust,
            @RequestParam("area") String area
    ){
        Account user = new Account();
        user.setAccount(account);
        user.setEmail(email);
        user.setPassword(password);
        user.setGold(gold);
        user.setDust(dust);
        user.setArea(area);
        return user;
    }
}

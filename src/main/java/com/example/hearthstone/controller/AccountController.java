package com.example.hearthstone.controller;

import com.example.hearthstone.entity.Account;
import com.example.hearthstone.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


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
            @RequestBody Account user
    ){
        return accountService.insert(user);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable("id") String id) {
        return accountService.findById(id);
    }

    @PutMapping("/accounts/{id}")
    public Account updateAccount(
            @PathVariable("id") String id,
            @RequestBody Account user
    ){
        user.setId(id);
        return accountService.update(user);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable("id") String id) {
        accountService.delete(id);
    }
}

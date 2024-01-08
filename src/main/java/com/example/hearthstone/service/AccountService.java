package com.example.hearthstone.service;

import com.example.hearthstone.entity.Account;
import com.example.hearthstone.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Account insert(Account account) {
        return accountRepository.insert(account);
    }

    public Account findById(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public void delete(String id) {
        accountRepository.deleteById(id);
    }

}

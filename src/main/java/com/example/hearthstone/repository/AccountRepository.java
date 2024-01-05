package com.example.hearthstone.repository;

import com.example.hearthstone.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    @Override
    List<Account> findAll();
}

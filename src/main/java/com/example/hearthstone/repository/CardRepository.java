package com.example.hearthstone.repository;

import com.example.hearthstone.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card,String> {
}

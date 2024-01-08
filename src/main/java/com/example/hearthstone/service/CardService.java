package com.example.hearthstone.service;

import com.example.hearthstone.entity.Card;
import com.example.hearthstone.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Page<Card> findAll(Pageable pageable){
        return cardRepository.findAll(pageable);
    }
}

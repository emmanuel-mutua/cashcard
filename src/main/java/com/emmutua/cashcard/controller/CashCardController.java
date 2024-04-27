package com.emmutua.cashcard.controller;

import com.emmutua.cashcard.entity.CashCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards") //requests must have this
public class CashCardController {
    @GetMapping("/{requestId}") //handler method for get
    public ResponseEntity<CashCard> getCashCardById(@PathVariable String requestId) {
        CashCard cashCard = new CashCard(299L, 233.23);
        return ResponseEntity.ok(cashCard);
    }
}

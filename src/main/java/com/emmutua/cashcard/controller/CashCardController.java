package com.emmutua.cashcard.controller;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.dtos.CashCardResponse;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.service.CashCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cash_cards") //requests must have this
@RequiredArgsConstructor
public class CashCardController {
    private final CashCardService cashCardService;

    @PostMapping
    public ResponseEntity<CashCardResponse> postCashCard(@RequestBody CashCardDto cashCardDto){
        CashCardResponse response = cashCardService.postNewCashCard(cashCardDto);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{requestId}")
    public ResponseEntity<CashCardResponse> updateCashCard(
            @RequestBody CashCardDto cashCardDto,
            @PathVariable Long requestId){
        CashCardResponse response = cashCardService.updateCashCard(cashCardDto, requestId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{requestId}") //handler method for get
    public ResponseEntity<CashCard> getCashCardById(@PathVariable Long requestId) {
        CashCard response = cashCardService.getCashCardById(requestId);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    public ResponseEntity<List<CashCard>> getAllCashCards() {
        List<CashCard> cashCards = cashCardService.findAll();
        return ResponseEntity.ok(cashCards);
    }
}


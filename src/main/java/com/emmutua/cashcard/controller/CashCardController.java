package com.emmutua.cashcard.controller;

import com.emmutua.cashcard.dtos.CashCardRequestDto;
import com.emmutua.cashcard.dtos.CashCardPostResponse;
import com.emmutua.cashcard.dtos.CashCardResponseDto;
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
    public ResponseEntity<CashCardPostResponse> postCashCard(@RequestBody CashCardRequestDto cashCardDto){
        CashCardPostResponse response = cashCardService.saveNewCashCard(cashCardDto);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/{requestId}")
    public ResponseEntity<CashCardPostResponse> updateCashCard(
            @RequestBody CashCardRequestDto cashCardDto,
            @PathVariable String  requestId){
        CashCardPostResponse response = cashCardService.updateCashCard(cashCardDto, requestId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{requestId}") //handler method for get
    public ResponseEntity<CashCardResponseDto> getCashCardById(@PathVariable String requestId) {
        CashCardResponseDto response = cashCardService.getCashCardById(requestId);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping
    public ResponseEntity<List<CashCardResponseDto>> getAllCashCards() {
        List<CashCardResponseDto> cashCards = cashCardService.findAll();
        return ResponseEntity.ok(cashCards);
    }
}


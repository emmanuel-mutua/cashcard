package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardRequestDto;
import com.emmutua.cashcard.dtos.CashCardPostResponse;
import com.emmutua.cashcard.dtos.CashCardResponseDto;
import com.emmutua.cashcard.entity.CashCard;

import java.util.List;

public interface CashCardService {
    CashCardPostResponse saveNewCashCard(CashCardRequestDto cashCardDto);

    CashCardPostResponse updateCashCard(CashCardRequestDto cashCardDto, String requestId);

    CashCardResponseDto getCashCardById(String requestId);

    List<CashCardResponseDto> findAll();
}

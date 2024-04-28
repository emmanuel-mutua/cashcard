package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.dtos.CashCardResponse;
import com.emmutua.cashcard.entity.CashCard;

import java.util.List;

public interface CashCardService {
    CashCardResponse postNewCashCard(CashCardDto cashCardDto);

    CashCardResponse updateCashCard(CashCardDto cashCardDto, Long requestId);

    CashCard getCashCardById(Long requestId);

    List<CashCard> findAll();
}

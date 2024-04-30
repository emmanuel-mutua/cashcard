package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.dtos.CashCardResponse;
import com.emmutua.cashcard.entity.CashCard;
import org.bson.types.ObjectId;

import java.util.List;

public interface CashCardService {
    CashCardResponse saveNewCashCard(CashCardDto cashCardDto);

    CashCardResponse updateCashCard(CashCardDto cashCardDto, String requestId);

    CashCard getCashCardById(String requestId);

    List<CashCard> findAll();
}

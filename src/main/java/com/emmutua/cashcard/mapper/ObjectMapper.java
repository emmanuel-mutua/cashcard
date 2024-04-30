package com.emmutua.cashcard.mapper;

import com.emmutua.cashcard.dtos.CashCardRequestDto;
import com.emmutua.cashcard.dtos.CashCardResponseDto;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapper {
    public CashCard toCashCard(CashCardRequestDto cashCardDto) {
        if (cashCardDto == null){
            throw new ApiRequestException("cashCardDto cannot be null");
        }
        return CashCard.builder()
                .amount(cashCardDto.getAmount())
                .build();
    }

    public CashCardRequestDto toCashCardDto(CashCard cashCard) {
        if (cashCard == null){
            throw new ApiRequestException("cashCard cannot be null");
        }
        return  CashCardRequestDto.builder()
                .amount(cashCard.getAmount())
                .build();
    }

    public ObjectId toObjectId(String requestId){
        return new ObjectId(requestId);
    }
    public CashCardResponseDto toCashCardResponse(CashCard card) {
        if (card == null){
            throw new ApiRequestException("cashCard cannot be null");
        }
        return CashCardResponseDto.builder()
                .id(card.getId().toHexString())
                .amount(card.getAmount())
                .build();
    }
}

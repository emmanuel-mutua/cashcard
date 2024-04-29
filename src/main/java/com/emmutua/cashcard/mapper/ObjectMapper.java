package com.emmutua.cashcard.mapper;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapper {
    public CashCard toCashCard(CashCardDto cashCardDto) {
        if (cashCardDto == null){
            throw new ApiRequestException("cashCardDto cannot be null");
        }
        return CashCard.builder()
                .amount(cashCardDto.getAmount())
                .build();
    }

    public CashCardDto toCashCardDto(CashCard cashCard) {
        if (cashCard == null){
            throw new ApiRequestException("cashCard cannot be null");
        }
        return  CashCardDto.builder()
                .amount(cashCard.getAmount())
                .build();
    }
}

package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.dtos.CashCardResponse;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import com.emmutua.cashcard.repository.CashCardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashCardServiceImpl implements CashCardService{
    private final CashCardRepo cashCardRepo;
    @Override
    public CashCard getCashCardById(Long requestId) {
        try {
            CashCard cashCard = getCashCardFromRepo(requestId);
            return cashCard;
        }catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<CashCard> findAll() {
        try {
            return cashCardRepo.findAll();
        }catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public CashCardResponse postNewCashCard(CashCardDto cashCardDto) {
        String newCashCardAdded = "New cash card added";
        try {
            CashCard cashCard = CashCard.builder()
                    .amount(cashCardDto.getAmount())
                    .build();
            cashCardRepo.save(cashCard);
            return getCashCardResponse(newCashCardAdded, cashCard);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public CashCardResponse updateCashCard(CashCardDto cashCardDto, Long requestId) {
        try {
            CashCard cashCard = getCashCardFromRepo(requestId);
            cashCard.setAmount(cashCardDto.getAmount());
            cashCardRepo.save(cashCard);
            return getCashCardResponse("Card Updated", cashCard);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    private CashCard getCashCardFromRepo(Long requestId) {
        return cashCardRepo.findById(requestId).orElseThrow(
                () -> new ApiRequestException("Card not found")
        );
    }

    private CashCardResponse getCashCardResponse(String message, CashCard cashCard){
        CashCardResponse response = CashCardResponse.builder()
                .id(cashCard.getId())
                .message("Card updated")
                .build();
        return response;
    }
}

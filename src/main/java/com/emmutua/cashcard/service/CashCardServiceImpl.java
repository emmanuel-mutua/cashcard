package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardDto;
import com.emmutua.cashcard.dtos.CashCardResponse;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import com.emmutua.cashcard.mapper.ObjectMapper;
import com.emmutua.cashcard.repository.CashCardRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CashCardServiceImpl implements CashCardService{
    private final CashCardRepo cashCardRepo;
    private final ObjectMapper objectMapper;
    @Override
    public CashCard getCashCardById(String requestId) {
        try {
            return getCashCardFromRepo(objectMapper.toObjectId(requestId));
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
    public CashCardResponse saveNewCashCard(CashCardDto cashCardDto) {
        String newCashCardAdded = "New cash card added";
        try {

            CashCard cashCard = objectMapper.toCashCard(cashCardDto);
            CashCard saved = cashCardRepo.save(cashCard);
            return getCashCardResponse(newCashCardAdded, saved);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public CashCardResponse updateCashCard(CashCardDto cashCardDto, String requestId) {
        try {
            CashCard cashCard = getCashCardFromRepo(objectMapper.toObjectId(requestId));
            cashCard.setAmount(cashCardDto.getAmount());
            cashCardRepo.save(cashCard);
            return getCashCardResponse("Card Updated", cashCard);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    private CashCard getCashCardFromRepo(ObjectId requestId) {
        return cashCardRepo.findById(requestId).orElseThrow(
                () -> new ApiRequestException("Card not found")
        );
    }

    private CashCardResponse getCashCardResponse(String message, CashCard cashCard){
        CashCardResponse response = new CashCardResponse(
                cashCard.getId(), message);
        return response;
    }
}

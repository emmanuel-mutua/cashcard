package com.emmutua.cashcard.service;

import com.emmutua.cashcard.dtos.CashCardRequestDto;
import com.emmutua.cashcard.dtos.CashCardPostResponse;
import com.emmutua.cashcard.dtos.CashCardResponseDto;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import com.emmutua.cashcard.mapper.ObjectMapper;
import com.emmutua.cashcard.repository.CashCardRepo;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CashCardServiceImpl implements CashCardService{
    private final CashCardRepo cashCardRepo;
    private final ObjectMapper objectMapper;
    @Override
    public CashCardResponseDto getCashCardById(String requestId) {
        try {
            return getCashCardResponseDtoFromRepo(objectMapper.toObjectId(requestId));
        }catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<CashCardResponseDto> findAll() {
        try {
            return cashCardRepo.findAll().stream()
                    .map(this.objectMapper::toCashCardResponse)
                    .collect(Collectors.toList());
        }catch (Exception e) {
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public CashCardPostResponse saveNewCashCard(CashCardRequestDto cashCardDto) {
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
    public CashCardPostResponse updateCashCard(CashCardRequestDto cashCardDto, String requestId) {
        try {
            CashCard cashCard = getCashCard(objectMapper.toObjectId(requestId));
            cashCard.setAmount(cashCardDto.getAmount());
            cashCardRepo.save(cashCard);
            return getCashCardResponse("Card Updated", cashCard);
        }catch (Exception e){
            throw new ApiRequestException(e.getMessage(), e.getCause());
        }
    }

    private CashCardResponseDto getCashCardResponseDtoFromRepo(ObjectId requestId) {
        Optional<CashCard> byId = cashCardRepo.findById(requestId);
        return byId
                .map(this.objectMapper::toCashCardResponse)
                .orElseThrow(
                () -> new ApiRequestException("Card not found")
        );
    }

    private CashCard getCashCard(ObjectId requestId) {
        Optional<CashCard> byId = cashCardRepo.findById(requestId);
        return byId
                .orElseThrow(
                        () -> new ApiRequestException("Card not found")
                );
    }

    private CashCardPostResponse getCashCardResponse(String message, CashCard cashCard){
        CashCardPostResponse response = new CashCardPostResponse(
                cashCard.getId(), message);
        return response;
    }
}

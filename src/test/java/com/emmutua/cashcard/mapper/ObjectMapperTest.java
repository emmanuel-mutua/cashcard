package com.emmutua.cashcard.mapper;

import com.emmutua.cashcard.dtos.CashCardRequestDto;
import com.emmutua.cashcard.entity.CashCard;
import com.emmutua.cashcard.exception.ApiRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObjectMapperTest {
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void toCashCard() {
        CashCardRequestDto cashCardDto = CashCardRequestDto.builder().amount(233.33).build();
        CashCard cashCard = objectMapper.toCashCard(cashCardDto);
        assertEquals(cashCardDto.getAmount(), cashCard.getAmount());
    }

    @Test
    void should_throw_exception_when_the_cashCard_is_null() {
        ApiRequestException apiRequestException = assertThrows(ApiRequestException.class, () -> objectMapper.toCashCardDto(null));
        assertEquals("cashCard cannot be null", apiRequestException.getMessage());
    }

    @Test
    void toCashCardDto() {
        CashCard cashCard = CashCard.builder().amount(233.33).build();
        CashCardRequestDto cashCardDto = objectMapper.toCashCardDto(cashCard);
        assertEquals(cashCardDto.getAmount(), cashCard.getAmount());
    }
}
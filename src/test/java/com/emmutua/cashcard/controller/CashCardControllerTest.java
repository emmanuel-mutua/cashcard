package com.emmutua.cashcard.controller;

import com.emmutua.cashcard.entity.CashCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CashCardController cashCardController;

    @Test
    void shouldReturnCashCardWHenDataIsSaved(){
        ResponseEntity<CashCard> response = cashCardController.getCashCardById("99");
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
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

    @Test
    void shouldReturnCashCardWHenDataIsSaved(){
        ResponseEntity<CashCard> response = testRestTemplate.getForEntity("/cashcards/99", CashCard.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
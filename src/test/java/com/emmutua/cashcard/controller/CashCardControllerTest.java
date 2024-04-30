package com.emmutua.cashcard.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    CashCardController cashCardController;

    @Test
    void shouldReturnCashCardWHenDataIsSaved(){
//        ResponseEntity<CashCard> response = cashCardController.getCashCardById(99L);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
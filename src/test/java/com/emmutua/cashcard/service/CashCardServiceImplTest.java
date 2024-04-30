package com.emmutua.cashcard.service;

import com.emmutua.cashcard.mapper.ObjectMapper;
import com.emmutua.cashcard.repository.CashCardRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CashCardServiceImplTest {
    //Executed at the beginning of clas
    /**
     * We need to mock services cashCardRepo and the objectMapper in order to run
     * the cashCardService in isolation
     */
    @InjectMocks
    CashCardServiceImpl cashCardService;

    @Mock
    CashCardRepo cashCardRepo;
    @Mock
    ObjectMapper objectMapper;

    // Executed before running each test
    //Tell MockFramework we need to start the mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // after each method
    @AfterEach
    void tearDown() {

    }


    @Test
    void getCashCardById() {
    }

    @Test
    void findAll() {
    }

    /*
     @Test
     void should_successfully_create_a_new_cashCard() {
         CashCardDto cashCardDto = CashCardDto.builder()
                 .amount(23.33)
                 .build();
         CashCard card = CashCard.builder()
                 .amount(23.33)
                 .build();
         CashCard savedCard = CashCard.builder()
                 .id(23L)
                 .amount(23.33)
                 .build();

         //Mock calls. run calls in isolation
         Mockito.when(objectMapper.toCashCard(cashCardDto)).thenReturn(card);
         Mockito.when(objectMapper.toCashCardDto(savedCard)).thenReturn(
                  CashCardDto.builder()
                          .amount(savedCard.getAmount())
                          .build()
         );
         Mockito.when(cashCardRepo.save(card)).thenReturn(savedCard);
         CashCardResponse response = cashCardService.saveNewCashCard(cashCardDto);
         assertEquals("New cash card added", response.getMessage());
         Mockito.verify(cashCardRepo, Mockito.times(1)).save(card);
     }
 */
    @Test
    void updateCashCard() {
    }
}
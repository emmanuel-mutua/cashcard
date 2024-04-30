package com.emmutua.cashcard;

import com.emmutua.cashcard.entity.CashCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest //marks it a test class that uses the Jackson framework - provides extensive Json testing and parsing support
public class CashCardJsonTest {
        @Autowired
    private JacksonTester<CashCard> json;
    String expected = """
                    {
                    "id": "99",
                    "amount": "123.45"
                    }
                    """;
        @Test
    void cashCardSerializationTest() throws IOException{
            CashCard card = new CashCard(99L, 123.45);
//            assertThat(json.write(card)).isStrictlyEqualToJson(expected);
            assertThat(json.write(card)).hasJsonPathNumberValue("@.id");
            assertThat(json.write(card)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
            assertThat(json.write(card)).hasJsonPathNumberValue("@.amount");
            assertThat(json.write(card)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
        }

        @Test
    void cashCardDeserializationTest() throws IOException {
            assertThat(json.parse(expected)).isEqualTo(new CashCard(99L, 123.45));
            assertThat(json.parseObject(expected).getId()).isEqualTo(99L);
            assertThat(json.parseObject(expected).getAmount()).isEqualTo(123.45);
        }
}

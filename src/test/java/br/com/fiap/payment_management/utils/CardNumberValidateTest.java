package br.com.fiap.payment_management.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardNumberValidateTest {

    @Test
    public void shouldValidateCardNumberWithSuccess() {
        String cardNumber = "1234-1234-1234-1234";

        boolean result = CardNumberValidate.isAValidCardNumber(cardNumber);

        assertTrue(result);
    }

    @Test
    public void shouldValidateCardNumberWithErrorWhenNumberOfCaracteresIsDifferente16() {
        String cardNumber = "1234-1234";

        boolean result = CardNumberValidate.isAValidCardNumber(cardNumber);

        assertFalse(result);
    }

    @Test
    public void shouldValidateCardNumberWithErrorWhenNumberFormatIsIncorrect() {
        String cardNumber = "123456-12345-12345";

        boolean result = CardNumberValidate.isAValidCardNumber(cardNumber);

        assertFalse(result);
    }
}

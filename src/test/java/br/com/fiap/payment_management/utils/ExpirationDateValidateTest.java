package br.com.fiap.payment_management.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpirationDateValidateTest {

    @Test
    public void shouldValidateCardDateWithSuccess() {
        String expirationDate = "05/28";

        boolean result = ExpirationDateValidate.isAValidExpirationDate(expirationDate);

        assertTrue(result);
    }

    @Test
    public void shouldValidateCardDateWithError() {
        String expirationDate = "05/2028";

        boolean result = ExpirationDateValidate.isAValidExpirationDate(expirationDate);

        assertFalse(result);
    }
}

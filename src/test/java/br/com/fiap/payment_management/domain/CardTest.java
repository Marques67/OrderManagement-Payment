package br.com.fiap.payment_management.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {

    private final String number = "1234-1234-1234-1234";
    private final Integer cvv = 123;
    private final String nameOnCard = "JOAO M SILVA";
    private final String expirationDate = "05/28";

    @Test
    void throwsExceptionWhenIdIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(null, this.number, this.cvv, this.nameOnCard, this.expirationDate),
                "Id is required"
        );
    }

    @Test
    void throwsExceptionWhenIdLessThanZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(-1L, number, this.cvv, this.nameOnCard, this.expirationDate),
                "Id is required"
        );
    }

    @Test
    void throwsExceptionWhenNumberIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(null, this.cvv, this.nameOnCard, this.expirationDate),
                "Number is required"
        );
    }

    @Test
    void throwsExceptionWhenNumberIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card("", this.cvv, this.nameOnCard, this.expirationDate),
                "Number is required"
        );
    }

    @Test
    void throwsExceptionWhenNumberIsIncorrect() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card("1234-1234", this.cvv, this.nameOnCard, this.expirationDate),
                "Invalid card number"
        );
    }

    @Test
    void throwsExceptionWhenCvvIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, null, this.nameOnCard, this.expirationDate),
                "Cvv is required"
        );
    }

    @Test
    void throwsExceptionWhenCvvIsIncorrect() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, 1234, this.nameOnCard, this.expirationDate),
                "Cvv is invalid"
        );
    }

    @Test
    void throwsExceptionWhenNameOnCardIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, this.cvv, null, this.expirationDate),
                "Name on card is required"
        );
    }

    @Test
    void throwsExceptionWhenNameOnCardIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, this.cvv, "", this.expirationDate),
                "Name on card is required"
        );
    }

    @Test
    void throwsExceptionWhenExpirationDateIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, this.cvv, this.nameOnCard, null),
                "Expiration date is required"
        );
    }

    @Test
    void throwsExceptionWhenExpirationDateIsEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, this.cvv, this.nameOnCard, ""),
                "Expiration date is required"
        );
    }

    @Test
    void throwsExceptionWhenExpirationDateIsIncorrect() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Card(this.number, this.cvv, this.nameOnCard, "05/2028"),
                "Invalid expiration date"
        );
    }
}

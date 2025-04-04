package br.com.fiap.payment_management.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    private final Card card = new Card(1L, "1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");
    private final Double orderValue = 198.99;
    private final String paymentRequestId = "7d7087ae-1f1a-40ab-9be7-44a0f82625ff";

    @Test
    void throwsExceptionWhenCardIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(null, this.orderValue, this.paymentRequestId),
                "Card is required"
        );
    }

    @Test
    void throwsExceptionWhenOrderValueIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(this.card, null, this.paymentRequestId),
                "Order value is required"
        );
    }

    @Test
    void throwsExceptionWhenPaymentRequestIdIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(this.card, this.orderValue, null),
                "Payment Request id is required"
        );
    }
}

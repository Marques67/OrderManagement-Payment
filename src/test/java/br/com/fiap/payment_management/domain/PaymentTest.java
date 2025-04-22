package br.com.fiap.payment_management.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    private final Card card = new Card(1L, "1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");
    private final Double orderValue = 198.99;
    private final String paymentRequestId = "7d7087ae-1f1a-40ab-9be7-44a0f82625ff";
    private final Long orderId = 1L;

    @Test
    void throwsExceptionWhenCardIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(null, this.orderValue, this.paymentRequestId, this.orderId),
                "Card is required"
        );
    }

    @Test
    void throwsExceptionWhenPaymentIdIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(null, this.card, this.orderValue, this.paymentRequestId, this.orderId),
                "Id is required"
        );
    }

    @Test
    void throwsExceptionWhenPaymentIDIsLessThanZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(-1L, this.card, this.orderValue, this.paymentRequestId, this.orderId),
                "Id is required"
        );
    }

    @Test
    void throwsExceptionWhenOrderValueIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(null, this.paymentRequestId),
                "Order value is required"
        );
    }

    @Test
    void throwsExceptionWhenPaymentRequestIdIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(this.orderValue, null),
                "Payment Request id is required"
        );
    }

    @Test
    void throwsExceptionWhenOrderIdIsNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(1L, this.card, this.orderValue, this.paymentRequestId, null),
                "Order id is required"
        );
    }

    @Test
    void throwsExceptionWhenOrderIdIsLessThanZero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Payment(1L, this.card, this.orderValue, this.paymentRequestId, -1L),
                "Order id is required"
        );
    }
}

package br.com.fiap.payment_management.domain;

import java.util.Objects;

public class Payment {

    private Long id;
    private Card card;
    private Double orderValue;
    private String paymentRequestId;
    private Long orderId;

    public Payment(Long id, Card card, Double orderValue, String paymentRequestId, Long orderId) {
        validatePaymentId(id);
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentRequestId(paymentRequestId);
        validateOrderId(orderId);

        this.id = id;
        this.card = card;
        this.orderValue = orderValue;
        this.paymentRequestId = paymentRequestId;
        this.orderId = orderId;
    }

    public Payment(Card card, Double orderValue, String paymentRequestId, Long orderId) {
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentRequestId(paymentRequestId);
        validateOrderId(orderId);

        this.card = card;
        this.orderValue = orderValue;
        this.paymentRequestId = paymentRequestId;
        this.orderId = orderId;
    }

    public Payment(Double orderValue, String paymentRequestId) {
        validatePaymentValue(orderValue);
        validatePaymentRequestId(paymentRequestId);

        this.orderValue = orderValue;
        this.paymentRequestId = paymentRequestId;
    }

    private void validatePaymentId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id is required");
        }
    }

    private void validatePaymentCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card is required");
        }
    }

    private void validatePaymentValue(Double orderValue) {
        if (orderValue == null) {
            throw new IllegalArgumentException("Order value is required");
        }
    }

    private void validatePaymentRequestId(String paymentRequestId) {
        if (paymentRequestId == null || paymentRequestId.isEmpty()) {
            throw new IllegalArgumentException("Payment Request id is required");
        }
    }

    private void validateOrderId(Long orderId) {
        if (orderId == null || orderId <= 0) {
            throw new IllegalArgumentException("Order id is required");
        }
    }

    public Long getId() {
        return id;
    }

    public Card getCard() {
        return card;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public String getPaymentRequestId() {
        return paymentRequestId;
    }

    public Long getOrderId() {
        return orderId;
    }
}

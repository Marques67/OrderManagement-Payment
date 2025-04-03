package br.com.fiap.payment_management.domain;

import java.util.Objects;

public class Payment {

    private Long id;
    private Card card;
    private Double orderValue;
    private String paymentRequestId;

    public Payment(Long id, Card card, Double orderValue, String paymentRequestId) {
        validatePaymentId(id);
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentRequestId(paymentRequestId);

        this.id = id;
        this.card = card;
        this.orderValue = orderValue;
        this.paymentRequestId = paymentRequestId;
    }

    public Payment(Card card, Double orderValue, String paymentRequestId) {
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentRequestId(paymentRequestId);

        this.card = card;
        this.orderValue = orderValue;
        this.paymentRequestId = paymentRequestId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public String getPaymentRequestId() {
        return paymentRequestId;
    }

    public void setPaymentRequestId(String paymentRequestId) {
        this.paymentRequestId = paymentRequestId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id)
                && Objects.equals(card, payment.card)
                && Objects.equals(orderValue, payment.orderValue)
                && Objects.equals(paymentRequestId, payment.paymentRequestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, orderValue, paymentRequestId);
    }
}

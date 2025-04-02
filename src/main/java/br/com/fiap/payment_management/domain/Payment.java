package br.com.fiap.payment_management.domain;

import br.com.fiap.payment_management.enums.PaymentType;

import java.util.Objects;

public class Payment {

    private Long id;
    private Card card;
    private Double orderValue;
    private PaymentType paymentType;
    private String paymentRequestId;

    public Payment(Long id, Card card, Double orderValue, PaymentType paymentType, String paymentRequestId) {
        validatePaymentId(id);
        if (card != null && paymentType.equals(PaymentType.CARD)) {
            validatePaymentCard(card);
        }
        validatePaymentValue(orderValue);
        validatePaymentType(paymentType);
        validatePaymentRequestId(paymentRequestId);

        this.id = id;
        this.card = card;
        this.orderValue = orderValue;
        this.paymentType = paymentType;
        this.paymentRequestId = paymentRequestId;
    }

    public Payment(Card card, Double orderValue, PaymentType paymentType, String paymentRequestId) {
        if (card != null && paymentType.equals(PaymentType.CARD)) {
            validatePaymentCard(card);
        }
        validatePaymentValue(orderValue);
        validatePaymentType(paymentType);
        validatePaymentRequestId(paymentRequestId);

        this.card = card;
        this.orderValue = orderValue;
        this.paymentType = paymentType;
        this.paymentRequestId = paymentRequestId;
    }

    public Payment(Double orderValue, PaymentType paymentType, String paymentRequestId) {
        validatePaymentValue(orderValue);
        validatePaymentType(paymentType);
        validatePaymentRequestId(paymentRequestId);

        this.orderValue = orderValue;
        this.paymentType = paymentType;
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

    private void validatePaymentType(PaymentType paymentType) {
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment Type is required");
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
                && paymentType == payment.paymentType
                && Objects.equals(paymentRequestId, payment.paymentRequestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, orderValue, paymentType, paymentRequestId);
    }
}

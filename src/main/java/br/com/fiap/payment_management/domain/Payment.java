package br.com.fiap.payment_management.domain;

import br.com.fiap.payment_management.enums.PaymentType;

import java.util.Objects;

public class Payment {

    private Long id;
    private Card card;
    private Double orderValue;
    private PaymentType paymentType;

    public Payment(Long id, Card card, Double orderValue, PaymentType paymentType) {
        validatePaymentId(id);
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentType(paymentType);

        this.id = id;
        this.card = card;
        this.orderValue = orderValue;
        this.paymentType = paymentType;
    }

    public Payment(Card card, Double orderValue, PaymentType paymentType) {
        validatePaymentCard(card);
        validatePaymentValue(orderValue);
        validatePaymentType(paymentType);

        this.card = card;
        this.orderValue = orderValue;
        this.paymentType = paymentType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id)
                && Objects.equals(card, payment.card)
                && Objects.equals(orderValue, payment.orderValue)
                && paymentType == payment.paymentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, orderValue, paymentType);
    }
}

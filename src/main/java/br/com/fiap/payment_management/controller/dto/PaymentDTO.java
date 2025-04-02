package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.enums.PaymentType;

public record PaymentDTO(Long id, CardDTO card, Double orderValue, PaymentType paymentType) {

    public PaymentDTO(Payment payment) {
        this(payment.getId(),
                payment.getCard() != null ? new CardDTO(payment.getCard()) : null,
                payment.getOrderValue(),
                payment.getPaymentType());
    }
}

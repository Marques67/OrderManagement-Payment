package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Payment;

public record PaymentDTO(Long id, CardDTO card, Double orderValue) {

    public PaymentDTO(Payment payment) {
        this(payment.getId(), new CardDTO(payment.getCard()), payment.getOrderValue());
    }
}

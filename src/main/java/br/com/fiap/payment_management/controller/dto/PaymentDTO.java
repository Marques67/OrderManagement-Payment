package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.enums.PaymentType;

public record PaymentDTO(Long id, CardDTO cardDTO, Double orderValue, PaymentType paymentType) {

    public PaymentDTO(Payment payment) {
        this(payment.getId(), new CardDTO(payment.getCard()), payment.getOrderValue(), payment.getPaymentType());
    }

}

package br.com.fiap.payment_management.adapters;

import br.com.fiap.payment_management.domain.Card;

import java.util.UUID;

public class MakePayment implements MakePaymentProducer {

    public String makePayment(Card card, Double orderValue) {
        if (orderValue >= 20000) {
            throw new RuntimeException("Insufficient credit");
        }
        return UUID.randomUUID().toString();
    }
}

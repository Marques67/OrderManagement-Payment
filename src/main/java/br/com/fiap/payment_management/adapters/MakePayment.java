package br.com.fiap.payment_management.adapters;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.enums.PaymentType;

import java.util.UUID;

public class MakePayment implements MakePaymentProducer {

    public String makePayment(Card card, Double orderValue, PaymentType paymentType) {
        return UUID.randomUUID().toString();
    }

    public String makePayment(Double orderValue, PaymentType paymentType) {
        return UUID.randomUUID().toString();
    }
}

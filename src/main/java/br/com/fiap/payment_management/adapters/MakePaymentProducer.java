package br.com.fiap.payment_management.adapters;

import br.com.fiap.payment_management.domain.Card;

public interface MakePaymentProducer {

    String makePayment(Card card, Double orderValue);

}

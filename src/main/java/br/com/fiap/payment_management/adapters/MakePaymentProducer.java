package br.com.fiap.payment_management.adapters;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.enums.PaymentType;

public interface MakePaymentProducer {

    String makePayment(Card card, Double orderValue, PaymentType paymentType);

}

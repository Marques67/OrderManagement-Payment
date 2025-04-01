package br.com.fiap.payment_management.usecase;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.enums.PaymentType;

public class PaymentUseCase {

    public static Payment makePayment(Card card, Double orderValue, PaymentType paymentType) {
        return new Payment(card, orderValue, paymentType);
    }
}

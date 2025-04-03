package br.com.fiap.payment_management.usecase;

import br.com.fiap.payment_management.adapters.MakePaymentProducer;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;

public class PaymentUseCase {

    private final MakePaymentProducer makePaymentProducer;

    public PaymentUseCase(MakePaymentProducer makePaymentProducer) {
        this.makePaymentProducer = makePaymentProducer;
    }

    public Payment makePayment(Card card, Double orderValue) {
        String paymentRequestId = this.makePaymentProducer.makePayment(card, orderValue);
        return new Payment(card, orderValue, paymentRequestId);
    }
}

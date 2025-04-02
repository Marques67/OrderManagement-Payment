package br.com.fiap.payment_management.usecase;

import br.com.fiap.payment_management.adapters.MakePaymentProducer;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.enums.PaymentType;

public class PaymentUseCase {

    private final MakePaymentProducer makePaymentProducer;

    public PaymentUseCase(MakePaymentProducer makePaymentProducer) {
        this.makePaymentProducer = makePaymentProducer;
    }

    public Payment makePayment(Card card, Double orderValue, PaymentType paymentType) {
        String paymentRequestId = this.makePaymentProducer.makePayment(card, orderValue, paymentType);
        return new Payment(card, orderValue, paymentType, paymentRequestId);
    }
}

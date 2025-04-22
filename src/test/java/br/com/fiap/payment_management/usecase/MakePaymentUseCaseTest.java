package br.com.fiap.payment_management.usecase;

import br.com.fiap.payment_management.adapters.MakePaymentProducer;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MakePaymentUseCaseTest {

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    @Mock
    private MakePaymentProducer makePaymentProducer;

    private final Card card = new Card(1L, "1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");
    private final Double orderValue = 198.99;
    private final String paymentRequestId = "7d7087ae-1f1a-40ab-9be7-44a0f82625ff";
    private final Long orderId = 1L;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            paymentUseCase = new PaymentUseCase(makePaymentProducer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldMakePayment() {
        when(makePaymentProducer.makePayment(any(), any())).thenReturn(this.paymentRequestId);

        var result = paymentUseCase.makePayment(this.card, this.orderValue, this.orderId);

        assertInstanceOf(Payment.class, result);
    }
}

package br.com.fiap.payment_management.gateway.database.jpa;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.entity.PaymentEntity;
import br.com.fiap.payment_management.gateway.database.jpa.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PaymentJpaGatewayTest {

    @InjectMocks
    private PaymentJpaGateway paymentJpaGateway;

    @Mock
    private PaymentRepository paymentRepository;

    private final Card card = new Card("1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");
    private final Double orderValue = 198.99;
    private final String paymentRequestId = "7d7087ae-1f1a-40ab-9be7-44a0f82625ff";
    private final Long orderId = 1L;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            paymentJpaGateway = new PaymentJpaGateway(paymentRepository);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCreatePaymentWithSuccess() {
        Payment payment = new Payment(this.card, this.orderValue, this.paymentRequestId, this.orderId);

        PaymentEntity paymentEntity = new PaymentEntity(payment);
        paymentEntity.setId(1L);

        when(paymentRepository.save(any())).thenReturn(paymentEntity);

        Payment result = paymentJpaGateway.createPayment(payment);

        assertEquals(payment.getOrderValue(), result.getOrderValue());
        assertEquals(payment.getPaymentRequestId(), result.getPaymentRequestId());
        assertEquals(payment.getCard().getNumber(), result.getCard().getNumber());
        assertEquals(payment.getCard().getCvv(), result.getCard().getCvv());
        assertEquals(payment.getCard().getNameOnCard(), result.getCard().getNameOnCard());
        assertEquals(payment.getCard().getExpirationDate(), result.getCard().getExpirationDate());
    }

    @Test
    public void shouldThrowExceptionWhenIdIsNotNull() {
        Payment payment = new Payment(1L, this.card, this.orderValue, this.paymentRequestId, this.orderId);

        when(paymentRepository.save(any())).thenReturn(new PaymentEntity(payment));

        assertThrows(IllegalArgumentException.class,
                () -> paymentJpaGateway.createPayment(payment), "Payment already exists");
    }

    @Test
    public void shouldFindPaymentByIdWithSuccess() {
        Payment payment = new Payment(this.card, this.orderValue, this.paymentRequestId, this.orderId);

        PaymentEntity paymentEntity = new PaymentEntity(payment);
        paymentEntity.setId(1L);

        when(paymentRepository.findById(any())).thenReturn(Optional.of(paymentEntity));

        Payment result = paymentJpaGateway.findById(1L);

        assertEquals(paymentEntity.getId(), result.getId());
        assertEquals(paymentEntity.getOrderValue(), result.getOrderValue());
        assertEquals(paymentEntity.getPaymentRequestId(), result.getPaymentRequestId());
        assertEquals(paymentEntity.getNumber(), result.getCard().getNumber());
        assertEquals(paymentEntity.getCvv(), result.getCard().getCvv());
        assertEquals(paymentEntity.getExpirationDate(), result.getCard().getExpirationDate());
        assertEquals(paymentEntity.getNameOnCard(), result.getCard().getNameOnCard());
    }

    @Test
    public void shouldThrowExceptionWhenPaymentEntityIsEmpty() {

        when(paymentRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> paymentJpaGateway.findById(1L), "Payment not found");
    }
}

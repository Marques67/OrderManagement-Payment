package br.com.fiap.payment_management.controller;

import br.com.fiap.payment_management.controller.dto.PaymentDTO;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.PaymentJpaGateway;
import br.com.fiap.payment_management.gateway.database.jpa.entity.PaymentEntity;
import br.com.fiap.payment_management.gateway.database.jpa.repository.PaymentRepository;
import br.com.fiap.payment_management.usecase.PaymentUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class PaymentControllerTest {

    @Mock
    private PaymentJpaGateway paymentJpaGateway;

    @Mock
    private PaymentUseCase paymentUseCase;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        try (AutoCloseable ignored = MockitoAnnotations.openMocks(this)) {
            paymentController = new PaymentController(paymentJpaGateway, paymentUseCase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateMakePaymentWithError() {
        Card card = new Card(1L, "1234-1234-1234-1234", 123,
                "JOAO M SILVA", "05/28");
        Payment payment = new Payment(1L, card,
                198.99, "7d7087ae-1f1a-40ab-9be7-44a0f82625ff", 1L);
        PaymentDTO dto = new PaymentDTO(payment);

        when(paymentUseCase.makePayment(any(), any(), any())).thenReturn(payment);
        when(paymentJpaGateway.createPayment(any())).thenThrow(new IllegalArgumentException("Payment already exists"));

        assertThrows(IllegalArgumentException.class,
                () -> paymentController.makePayment(dto),
                "Payment already exists"
        );
    }

    @Test
    public void validateMakePaymentWithSuccess() {
        Card card = new Card(1L, "1234-1234-1234-1234", 123,
                "JOAO M SILVA", "05/28");
        Payment payment = new Payment(1L, card,
                198.99, "7d7087ae-1f1a-40ab-9be7-44a0f82625ff", 1L);
        PaymentDTO dto = new PaymentDTO(payment);

        when(paymentJpaGateway.createPayment(any())).thenReturn(payment);

        PaymentDTO result = paymentController.makePayment(dto);

        assertEquals(dto, result);
    }

    @Test
    public void shouldFindPaymentById() throws Exception {
        Card card = new Card(1L, "1234-1234-1234-1234", 123,
                "JOAO M SILVA", "05/28");
        Payment payment = new Payment(1L, card,
                198.99, "7d7087ae-1f1a-40ab-9be7-44a0f82625ff", 1L);
        PaymentDTO dto = new PaymentDTO(payment);

        PaymentEntity paymentEntity = new PaymentEntity(1L, 198.99, "1234-1234-1234-1234", 123,
                "JOAO M SILVA", "05/28", "7d7087ae-1f1a-40ab-9be7-44a0f82625ff", 1L);

        when(paymentRepository.findById(any())).thenReturn(Optional.of(paymentEntity));
        when(paymentJpaGateway.findById(any())).thenReturn(new Payment(paymentEntity.getId(), card,
                paymentEntity.getOrderValue(), paymentEntity.getPaymentRequestId(), paymentEntity.getOrderId()));

        PaymentDTO result = paymentController.findById(1L);

        assertEquals(dto, result);
    }
}

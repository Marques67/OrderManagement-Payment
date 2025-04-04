package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.entity.PaymentEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentDtoTest {

    private final PaymentEntity paymentEntity = new PaymentEntity(1L, 198.99, "1234-1234-1234-1234", 123,
            "JOAO M SILVA", "05/28", "7d7087ae-1f1a-40ab-9be7-44a0f82625ff");

    @Test
    public void validatePaymentDtoWithError() {
        assertThrows(
                NullPointerException.class,
                () -> new PaymentDTO(null)
        );
    }

    @Test
    void validatePaymentDto() {
        Card card = new Card(1L, "1234-1234-1234-1234", 123,
                "JOAO M SILVA", "05/28");
        Payment payment = new Payment(1L, card,
                198.99, "7d7087ae-1f1a-40ab-9be7-44a0f82625ff");
        PaymentDTO dto = new PaymentDTO(payment);

        assertNotNull(dto);
        assertEquals(paymentEntity.getId(), dto.id());
        assertEquals(198.99, dto.orderValue());
        assertEquals("1234-1234-1234-1234", dto.card().number());
        assertEquals(123, dto.card().cvv());
        assertEquals("JOAO M SILVA", dto.card().nameOnCard());
        assertEquals("05/28", dto.card().expirationDate());
    }
}

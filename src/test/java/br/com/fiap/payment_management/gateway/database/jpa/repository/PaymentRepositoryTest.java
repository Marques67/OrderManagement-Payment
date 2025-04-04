package br.com.fiap.payment_management.gateway.database.jpa.repository;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.entity.PaymentEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    private final Card card = new Card("1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");
    private final Double orderValue = 198.99;
    private final String paymentRequestId = "7d7087ae-1f1a-40ab-9be7-44a0f82625ff";

    @Test
    public void shouldSavePayment() {
        Payment payment = new Payment(this.card, this.orderValue, this.paymentRequestId);
        PaymentEntity savedPayment = paymentRepository.save(new PaymentEntity(payment));

        assertNotNull(savedPayment.getId());
        assertEquals(this.card.getNumber(), savedPayment.getNumber());
        assertEquals(this.card.getCvv(), savedPayment.getCvv());
        assertEquals(this.card.getNameOnCard(), savedPayment.getNameOnCard());
        assertEquals(this.card.getExpirationDate(), savedPayment.getExpirationDate());
        assertEquals(this.orderValue, savedPayment.getOrderValue());
        assertEquals(this.paymentRequestId, savedPayment.getPaymentRequestId());
        assertEquals(this.card.getNumber(), savedPayment.getNumber());
    }
}

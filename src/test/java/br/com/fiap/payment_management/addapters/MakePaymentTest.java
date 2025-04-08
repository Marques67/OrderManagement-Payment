package br.com.fiap.payment_management.addapters;

import br.com.fiap.payment_management.adapters.MakePayment;
import br.com.fiap.payment_management.domain.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MakePaymentTest {

    @InjectMocks
    private MakePayment makePayment;

    private final Card card = new Card(1L, "1234-1234-1234-1234", 123, "JOAO M SILVA",
            "05/28");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldThrowExceptionWhenCreditIsInsufficient() {
        assertThrows(RuntimeException.class,
                () -> makePayment.makePayment(this.card, 20001.0), "Insufficient credit");
    }

    @Test
    void shouldReturnUUIDWhenCreditIsSufficient() {
        String payment = makePayment.makePayment(this.card, 10001.0);

        assertNotNull(payment);
    }
}

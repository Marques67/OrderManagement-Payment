package br.com.fiap.payment_management.controller;

import br.com.fiap.payment_management.controller.dto.CardDTO;
import br.com.fiap.payment_management.controller.dto.PaymentDTO;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.PaymentJpaGateway;
import br.com.fiap.payment_management.usecase.PaymentUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentJpaGateway paymentJpaGateway;

    private final PaymentUseCase paymentUseCase;

    public PaymentController(PaymentJpaGateway paymentJpaGateway, PaymentUseCase paymentUseCase) {
        this.paymentJpaGateway = paymentJpaGateway;
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping("/makePayment")
    public PaymentDTO makePayment(@RequestBody PaymentDTO paymentDTO) {
        CardDTO cardDTO = paymentDTO.card();

        Card card = new Card(cardDTO.number(), cardDTO.cvv(), cardDTO.nameOnCard(), cardDTO.expirationDate());
        Payment payment = paymentUseCase.makePayment(card, paymentDTO.orderValue());

        return new PaymentDTO(paymentJpaGateway.createPayment(payment));
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable("id") Long id) {
        return new PaymentDTO(paymentJpaGateway.findById(id));
    }

}

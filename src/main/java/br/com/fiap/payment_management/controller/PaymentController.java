package br.com.fiap.payment_management.controller;

import br.com.fiap.payment_management.controller.dto.CardDTO;
import br.com.fiap.payment_management.controller.dto.PaymentDTO;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.usecase.PaymentUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/makePayment")
    public PaymentDTO makePayment(PaymentDTO paymentDTO) {
        CardDTO cardDTO = paymentDTO.cardDTO();
        Card card = new Card(cardDTO.number(), cardDTO.cvv(), cardDTO.nameOnCard(), cardDTO.expirationDate(), cardDTO.cardType());

        Payment payment = PaymentUseCase.makePayment(card, paymentDTO.orderValue(), paymentDTO.paymentType());

        return new PaymentDTO(payment);
    }

}

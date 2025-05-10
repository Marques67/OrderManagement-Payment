package br.com.fiap.payment_management.controller;

import br.com.fiap.payment_management.controller.dto.CardDTO;
import br.com.fiap.payment_management.controller.dto.PaymentDTO;
import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.database.jpa.PaymentJpaGateway;
import br.com.fiap.payment_management.usecase.PaymentUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Realizar pagamento",
            description = "A chamada deste endpoint faz a realização do pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Realização de pagamento de pedidos"),
    })
    @PostMapping("/makePayment")
    public PaymentDTO makePayment(@RequestBody PaymentDTO paymentDTO) {
        CardDTO cardDTO = paymentDTO.card();

        Card card = new Card(cardDTO.number(), cardDTO.cvv(), cardDTO.nameOnCard(), cardDTO.expirationDate());
        Payment payment = paymentUseCase.makePayment(card, paymentDTO.orderValue(), paymentDTO.orderId());

        return new PaymentDTO(paymentJpaGateway.createPayment(payment));
    }

    @Operation(
            summary = "Buscar pagamento pelo ID",
            description = "A chamada deste endpoint busca o pagamento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar pagamento pelo ID"),
    })
    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable("id") Long id) {
        return new PaymentDTO(paymentJpaGateway.findById(id));
    }

}

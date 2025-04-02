package br.com.fiap.payment_management.config;

import br.com.fiap.payment_management.adapters.MakePayment;
import br.com.fiap.payment_management.adapters.MakePaymentProducer;
import br.com.fiap.payment_management.controller.PaymentController;
import br.com.fiap.payment_management.gateway.database.jpa.PaymentJpaGateway;
import br.com.fiap.payment_management.gateway.database.jpa.repository.PaymentRepository;
import br.com.fiap.payment_management.usecase.PaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentJpaGateway paymentJpaGateway(PaymentRepository paymentRepository) {
        return new PaymentJpaGateway(paymentRepository);
    }

    @Bean
    public PaymentController paymentController(PaymentJpaGateway paymentJpaGateway, PaymentUseCase paymentUseCase) {
        return new PaymentController(paymentJpaGateway, paymentUseCase);
    }

    @Bean
    public PaymentUseCase paymentUseCase(MakePaymentProducer makePaymentProducer) {
        return new PaymentUseCase(makePaymentProducer);
    }

    @Bean
    public MakePaymentProducer makePaymentProducer() {
        return new MakePayment();
    }
}

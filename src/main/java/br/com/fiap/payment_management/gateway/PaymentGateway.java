package br.com.fiap.payment_management.gateway;
import br.com.fiap.payment_management.domain.Payment;

public interface PaymentGateway {

    Payment findById(Long id);

    Payment createPayment(Payment payment);
}

package br.com.fiap.payment_management.gateway;
import br.com.fiap.payment_management.domain.Payment;

public interface PaymentGateway {

    Payment findById(Long id);

    Payment create(Payment payment);

    Payment update(Payment payment);

    void delete(Payment payment);
}

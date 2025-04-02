package br.com.fiap.payment_management.gateway.database.jpa;

import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.gateway.PaymentGateway;
import br.com.fiap.payment_management.gateway.database.jpa.entity.PaymentEntity;
import br.com.fiap.payment_management.gateway.database.jpa.repository.PaymentRepository;

import java.util.Optional;

public class PaymentJpaGateway implements PaymentGateway {

    private final PaymentRepository paymentRepository;

    public PaymentJpaGateway(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment findById(Long id) {
        return convertOptionalToDomain(paymentRepository.findById(id));
    }

    @Override
    public Payment createPayment(Payment payment) {
        if (payment.getId() != null) {
            throw new IllegalArgumentException("Payment already exists");
        }

        PaymentEntity paymentEntity = paymentRepository.save(new PaymentEntity(payment));
        return paymentEntity.toDomain();
    }

    private Payment convertOptionalToDomain(Optional<PaymentEntity> paymentEntity) {
        if (paymentEntity.isEmpty()) {
            throw new IllegalArgumentException("Payment not found");
        }

        return paymentEntity.get().toDomain();
    }

}

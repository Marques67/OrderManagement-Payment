package br.com.fiap.payment_management.gateway.database.jpa.entity;

import br.com.fiap.payment_management.domain.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_card")
    private CardEntity cardEntity;

    private Double orderValue;

    public PaymentEntity() {}

    public PaymentEntity(Payment payment) {
        this.cardEntity = new CardEntity(payment.getCard());
        this.orderValue = payment.getOrderValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardEntity getCardEntity() {
        return cardEntity;
    }

    public void setCardEntity(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }
}

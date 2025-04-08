package br.com.fiap.payment_management.gateway.database.jpa.entity;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_value")
    private Double orderValue;

    private String number;

    private Integer cvv;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "payment_request_id")
    private String paymentRequestId;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, Double orderValue, String number, Integer cvv, String nameOnCard,
                         String expirationDate, String paymentRequestId) {
        this.id = id;
        this.orderValue = orderValue;
        this.number = number;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.paymentRequestId = paymentRequestId;
    }

    public PaymentEntity(Payment payment) {
        Card card = payment.getCard();

        this.orderValue = payment.getOrderValue();
        this.id = card.getId();
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.nameOnCard = card.getNameOnCard();
        this.expirationDate = card.getExpirationDate();
        this.paymentRequestId = payment.getPaymentRequestId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getPaymentRequestId() {
        return paymentRequestId;
    }

    public Payment toDomain() {
        Card card = new Card(number, cvv, nameOnCard, expirationDate);
        return new Payment(id, card, orderValue, paymentRequestId);
    }
}

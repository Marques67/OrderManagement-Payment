package br.com.fiap.payment_management.gateway.database.jpa.entity;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.domain.Payment;
import br.com.fiap.payment_management.enums.CardType;
import br.com.fiap.payment_management.enums.PaymentType;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_value")
    private Double orderValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    private String number;

    private Integer cvv;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "payment_request_id")
    private String paymentRequestId;

    public PaymentEntity() {}

    public PaymentEntity(Payment payment) {
        Card card = payment.getCard();

        this.orderValue = payment.getOrderValue();
        this.paymentType = payment.getPaymentType();

        if (card != null) {
            this.id = card.getId();
            this.number = card.getNumber();
            this.cvv = card.getCvv();
            this.nameOnCard = card.getNameOnCard();
            this.expirationDate = card.getExpirationDate();
            this.cardType = card.getCardType();
        }

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

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getPaymentRequestId() {
        return paymentRequestId;
    }

    public void setPaymentRequestId(String paymentRequestId) {
        this.paymentRequestId = paymentRequestId;
    }

    public Payment toDomain() {
        if (paymentType.equals(PaymentType.CARD)) {
            Card card = new Card(number, cvv, nameOnCard, expirationDate, cardType);
            return new Payment(id, card, orderValue, paymentType, paymentRequestId);
        } else {
            return new Payment(id, null, orderValue, paymentType, paymentRequestId);
        }
    }
}

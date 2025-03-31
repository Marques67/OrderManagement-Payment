package br.com.fiap.payment_management.gateway.database.jpa.entity;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.enums.CardType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    private String number;

    private Integer cvv;

    private String nameOnCard;

    private String expirationDate;

    private CardType cardType;

    public CardEntity() {}

    public CardEntity(Card card) {
        this.number = card.getNumber();
        this.cvv = card.getCvv();
        this.nameOnCard = card.getNameOnCard();
        this.expirationDate = card.getExpirationDate();
        this.cardType = card.getCardType();
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
}

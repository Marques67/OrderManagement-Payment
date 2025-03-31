package br.com.fiap.payment_management.domain;

import br.com.fiap.payment_management.enums.CardType;
import br.com.fiap.payment_management.utils.CardDateValidate;
import br.com.fiap.payment_management.utils.CardNumberValidate;

import java.util.Objects;

public class Card {

    private String number;

    private Integer cvv;

    private String nameOnCard;

    private String expirationDate;

    private CardType cardType;

    public Card(String number, Integer cvv, String nameOnCard, String expirationDate, CardType cardType) {
        validateNumber(number);
        validateCvv(cvv);
        validateNameOnCard(nameOnCard);
        validateExpirationDate(expirationDate);
        validateCardType(cardType);

        this.number = number;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.cardType = cardType;
    }

    private void validateNumber(String number) {
        if (number == null || number.isBlank() || number.isEmpty()) {
            throw new IllegalArgumentException("Number is required");
        } else if (!CardNumberValidate.isAValidCardNumber(number)) {
            throw new IllegalArgumentException("Invalid card number");
        }
    }

    private void validateCvv(Integer cvv) {
        String cvvString = String.valueOf(cvv);
        if (cvvString == null) {
            throw new IllegalArgumentException("Cvv is required");
        } else if (cvvString.length() != 3) {
            throw new IllegalArgumentException("Cvv is invalid");
        }
    }

    private void validateNameOnCard(String nameOnCard) {
        if (nameOnCard == null || nameOnCard.isEmpty()) {
            throw new IllegalArgumentException("Name on card is required");
        }
    }

    private void validateExpirationDate(String expirationDate) {
        if (expirationDate == null || expirationDate.isEmpty()) {
            throw new IllegalArgumentException("Expiration date is required");
        } else if (!CardDateValidate.isAValidCardDate(expirationDate)) {
            throw new IllegalArgumentException("Invalid expiration date");
        }
    }

    private void validateCardType(CardType cardType) {
        if (cardType == null) {
            throw new IllegalArgumentException("Card type is required");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number)
                && Objects.equals(cvv, card.cvv)
                && Objects.equals(nameOnCard, card.nameOnCard)
                && Objects.equals(expirationDate, card.expirationDate)
                && cardType == card.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, cvv, nameOnCard, expirationDate, cardType);
    }
}

package br.com.fiap.payment_management.domain;

import br.com.fiap.payment_management.utils.ExpirationDateValidate;
import br.com.fiap.payment_management.utils.CardNumberValidate;

import java.util.Objects;

public class Card {

    private Long id;

    private String number;

    private Integer cvv;

    private String nameOnCard;

    private String expirationDate;

    public Card(Long id, String number, Integer cvv, String nameOnCard, String expirationDate) {
        validateCardId(id);
        validateNumber(number);
        validateCvv(cvv);
        validateNameOnCard(nameOnCard);
        validateExpirationDate(expirationDate);

        this.id = id;
        this.number = number;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
    }

    public Card(String number, Integer cvv, String nameOnCard, String expirationDate) {
        validateNumber(number);
        validateCvv(cvv);
        validateNameOnCard(nameOnCard);
        validateExpirationDate(expirationDate);

        this.number = number;
        this.cvv = cvv;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
    }

    private void validateCardId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id is required");
        }
    }

    private void validateNumber(String number) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Number is required");
        } else if (!CardNumberValidate.isAValidCardNumber(number)) {
            throw new IllegalArgumentException("Invalid card number");
        }
    }

    private void validateCvv(Integer cvv) {
        String cvvString = String.valueOf(cvv);
        if (cvv == null) {
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
        } else if (!ExpirationDateValidate.isAValidExpirationDate(expirationDate)) {
            throw new IllegalArgumentException("Invalid expiration date");
        }
    }

    public Long getId() {
        return id;
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

}

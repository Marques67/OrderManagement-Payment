package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Card;
import br.com.fiap.payment_management.enums.CardType;

public record CardDTO (String number, Integer cvv, String nameOnCard, String expirationDate, CardType cardType) {

    public CardDTO(Card card) {
        this(card.getNumber(), card.getCvv(), card.getNameOnCard(), card.getExpirationDate(), card.getCardType());
    }
}

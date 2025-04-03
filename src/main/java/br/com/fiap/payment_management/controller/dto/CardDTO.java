package br.com.fiap.payment_management.controller.dto;

import br.com.fiap.payment_management.domain.Card;

public record CardDTO(String number, Integer cvv, String nameOnCard, String expirationDate) {

    public CardDTO(Card card) {
        this(card.getNumber(), card.getCvv(), card.getNameOnCard(), card.getExpirationDate());
    }
}

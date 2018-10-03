package com.cbabackend.processor;

import com.cbabackend.beans.Card;

public class CardItemProcessorImpl implements CardItemProcessor {

	@Override
	public Card process(Card card) {

		card.setCardId(card.getCardId());
		card.setCardNumber(card.getCardNumber());
		card.setCardHolderName(card.getCardHolderName());
		card.setExpiryDate(card.getExpiryDate());
		card.setCvv(card.getCvv());
		card.setCardTypeId(card.getCardTypeId());

		return card;

	}//process(-)
}//class

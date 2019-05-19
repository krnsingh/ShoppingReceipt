package com.receipt.calculator.service.offer;


import com.receipt.calculator.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ItemsOnOffer {

    private final Map<Item, Offer> offers = new HashMap<>();

    public void addOfferToItem(final Item item, final Offer offer) {
        offers.put(item, offer);
    }

    public Optional<Offer> getOfferForItem(final Item item) {
        final Offer offer = offers.get(item);
        return offer == null ? Optional.empty() : Optional.of(offer);
    }
}

package com.receipt.calculator.service;

import com.receipt.calculator.model.Item;
import com.receipt.calculator.model.ReceiptItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SavingsCalculator {

    public List<ReceiptItem> calculate(final List<Item> cartItems, final ItemsOnOffer itemsOnOffer) {
        final List<ReceiptItem> savingItems = new ArrayList<>();
        final Map<Item, Long> countsByItem = cartItems.stream().collect(groupingBy(item -> item, Collectors.counting()));
        countsByItem.forEach((item, quantity) ->
                itemsOnOffer.getOfferForItem(item)
                        .ifPresent(offer ->
                                savingItems.add(calculateOfferSavingAndCreateReceiptItem(item, quantity, offer))));
        return savingItems;
    }

    private ReceiptItem calculateOfferSavingAndCreateReceiptItem(Item item, Long quantity, Offer offer) {
        return new ReceiptItem(item.getName() + offer.receiptLabel(),
                offer.calculateSaving(item, Float.valueOf(quantity)));
    }
}

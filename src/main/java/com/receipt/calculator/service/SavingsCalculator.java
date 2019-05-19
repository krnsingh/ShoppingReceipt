package com.receipt.calculator.service;

import com.receipt.calculator.model.CartItem;
import com.receipt.calculator.model.Item;
import com.receipt.calculator.model.ReceiptItem;
import com.receipt.calculator.service.offer.ItemsOnOffer;
import com.receipt.calculator.service.offer.Offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SavingsCalculator {

    public List<ReceiptItem> calculate(final List<CartItem> cartItems, final ItemsOnOffer itemsOnOffer) {
        final List<ReceiptItem> savingItems = new ArrayList<>();

        Map<Item, Double> quantitiesByItem = cartItems.stream().collect(groupingBy(CartItem::getItem, Collectors.summingDouble(CartItem::getQuantity)));

        quantitiesByItem.forEach((item, quantity) ->
                itemsOnOffer.getOfferForItem(item)
                        .ifPresent(offer ->
                                savingItems.add(calculateOfferSavingAndCreateReceiptItem(item, quantity.floatValue(), offer))));
        return savingItems;
    }

    private ReceiptItem calculateOfferSavingAndCreateReceiptItem(Item item, Float quantity, Offer offer) {
        return new ReceiptItem(item.getName() + offer.receiptLabel(),
                offer.calculateSaving(item, Float.valueOf(quantity)));
    }
}

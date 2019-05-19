package com.receipt.calculator.service;

import com.receipt.calculator.model.CartItem;
import com.receipt.calculator.model.ReceiptItem;
import com.receipt.calculator.service.offer.ItemsOnOffer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReceiptGenerator {

    final SavingsCalculator savingsCalculator = new SavingsCalculator();

    public List<String> generate(final List<CartItem> cartItems, final ItemsOnOffer itemsOnOffer) {
        final List<ReceiptItem> receiptItems = convertCartToReceiptItems(cartItems);
        final BigDecimal subTotal = receiptItems.stream().map(i -> i.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        final List<String> receiptLines = receiptItems.stream().map(ReceiptItem::toString).collect(Collectors.toList());

        receiptLines.add("SubTotal - " + subTotal);
        receiptLines.add("Savings");
        List<ReceiptItem> savings = convertCartToSavingReceiptItems(cartItems, itemsOnOffer);
        List<String> savingLines = savings.stream().map(ReceiptItem::toString).collect(Collectors.toList());

        final BigDecimal totalSavings = savings.stream().map(i -> i.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        savingLines.add("Total - " + subTotal.subtract(totalSavings).setScale(2, RoundingMode.HALF_UP));

        return Stream.concat(receiptLines.stream(), savingLines.stream()).collect(Collectors.toList());
    }

    private List<ReceiptItem> convertCartToSavingReceiptItems(List<CartItem> cartItems, ItemsOnOffer itemsOnOffer) {
        return savingsCalculator.calculate(cartItems, itemsOnOffer)
                .stream()
                .collect(Collectors.toList());
    }

    private List<ReceiptItem> convertCartToReceiptItems(List<CartItem> cartItems) {
        return cartItems.stream()
                .map(c -> new ReceiptItem(c.getItem().getName(), calculateCartItemAmount(c)))
                .collect(Collectors.toList());
    }

    private BigDecimal calculateCartItemAmount(final CartItem cartItem) {
        return cartItem.getItem().getPricePerUnit()
                .multiply(BigDecimal.valueOf(cartItem.getQuantity())).setScale(2,RoundingMode.HALF_UP);
    }
}

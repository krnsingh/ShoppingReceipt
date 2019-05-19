package com.receipt.calculator;

import com.receipt.calculator.model.CartItem;
import com.receipt.calculator.model.Item;
import com.receipt.calculator.service.ReceiptGenerator;
import com.receipt.calculator.service.offer.ItemsOnOffer;
import com.receipt.calculator.service.offer.ThreeForTwo;
import com.receipt.calculator.service.offer.TwoForOnePound;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReceiptApplication {


    public static void main(String[] args) {
        new ReceiptApplication().displayReceipt();
    }

    private void displayReceipt() {
        final ReceiptGenerator generator = new ReceiptGenerator();
        final List<String> receiptLines = generator.generate(generateCartItems(), generateOffersOnItems());
        receiptLines.stream().forEach(r-> System.out.println(r));
    }



    private ItemsOnOffer generateOffersOnItems() {
        final ItemsOnOffer itemsOnOffer = new ItemsOnOffer();
        itemsOnOffer.addOfferToItem(generateItem("coke", 1), new ThreeForTwo());
        itemsOnOffer.addOfferToItem(generateItem("tissues", 0.80f), new TwoForOnePound());
        return itemsOnOffer;
    }

    private List<CartItem> generateCartItems() {
        return Arrays.asList(
                generateCartItem(generateItem("coke", 1), 1),
                generateCartItem(generateItem("coke", 1), 1),
                generateCartItem(generateItem("coke", 1), 1),
                generateCartItem(generateItem("apple", 1), 1),
                generateCartItem(generateItem("tissues", 0.80f), 2),
                generateCartItem(generateItem("oranges", 3), 0.5f));
}

    private Item generateItem(final String name, final float price) {
        return new Item(name, BigDecimal.valueOf(price));
    }

    private CartItem generateCartItem(final Item item, final float quantity) {
        return new CartItem(item, quantity);
    }
}

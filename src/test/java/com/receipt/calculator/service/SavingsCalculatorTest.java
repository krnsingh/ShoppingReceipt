package com.receipt.calculator.service;

import com.receipt.calculator.model.CartItem;
import com.receipt.calculator.model.Item;
import com.receipt.calculator.model.ReceiptItem;
import com.receipt.calculator.service.offer.ItemsOnOffer;
import com.receipt.calculator.service.offer.ThreeForTwo;
import com.receipt.calculator.service.offer.TwoForOnePound;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SavingsCalculatorTest {

    private final SavingsCalculator calculator = new SavingsCalculator();
    private final String cokeItemName = "coke";
    private final String appleItemName = "apple";
    private final String tissuesItemName = "tissues";


    @Test
    public void threeCokesInCartWithThreeForTwoOffer() {
        //Given
        final List<CartItem> cartItems = Arrays.asList(
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(appleItemName, 1), 1));

        final ItemsOnOffer itemsOnOffer = new ItemsOnOffer();
        itemsOnOffer.addOfferToItem(generateItem("coke", 1), new ThreeForTwo());

        //When
        final List<ReceiptItem> savings = calculator.calculate(cartItems, itemsOnOffer);

        //Then
        assertThat(savings.size(), is(1));

        final ReceiptItem cokeSavings = new ReceiptItem(cokeItemName
                + new ThreeForTwo().receiptLabel(), BigDecimal.valueOf(1.0).setScale(2));
        assertThat(savings.contains(cokeSavings), is(true));
    }

    @Test
    public void threeCokesTwoTissuesInCartWithMultipleOffers() {
        //Given
        final List<CartItem> cartItems = Arrays.asList(
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(cokeItemName, 1), 1),
                generateCartItem(generateItem(appleItemName, 1), 1),
                generateCartItem(generateItem(tissuesItemName, 0.80f), 2));


        final ItemsOnOffer itemsOnOffer = new ItemsOnOffer();
        itemsOnOffer.addOfferToItem(generateItem(cokeItemName, 1), new ThreeForTwo());
        itemsOnOffer.addOfferToItem(generateItem(tissuesItemName, 0.80f), new TwoForOnePound());

        //When
        List<ReceiptItem> savings = calculator.calculate(cartItems, itemsOnOffer);

        //Then
        assertThat(savings.size(), is(2));

        final ReceiptItem cokeSavings = new ReceiptItem(cokeItemName
                + new ThreeForTwo().receiptLabel(), BigDecimal.valueOf(1.0).setScale(2));

        final ReceiptItem tissuesSavings = new ReceiptItem(tissuesItemName
                + new TwoForOnePound().receiptLabel(), BigDecimal.valueOf(0.60).setScale(2));

        assertThat(savings.contains(cokeSavings), is(true));
        assertThat(savings.contains(tissuesSavings), is(true));
    }

    private Item generateItem(final String name, final float price) {
        return new Item(name, BigDecimal.valueOf(price));
    }

    private CartItem generateCartItem(final Item item, final float quantity) {
        return new CartItem(item, quantity);
    }
}

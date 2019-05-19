package com.receipt.calculator.service.offer;

import com.receipt.calculator.model.Item;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemsOnOfferTest {

    @Test
    public void canAddAnItemOnOffer() {
        //Given
        final ItemsOnOffer itemsOnOffer = new ItemsOnOffer();
        final Item coke = new Item("coke", BigDecimal.valueOf(1));

        //When
        itemsOnOffer.addOfferToItem(coke, new ThreeForTwo());

        //Then
        assertThat(itemsOnOffer.getOfferForItem(coke), is(CoreMatchers.not(Optional.empty())));
        assertThat(itemsOnOffer.getOfferForItem(coke).get(), is(instanceOf(ThreeForTwo.class)));
    }

    @Test
    public void canAddMultipleItemOnOffer() {
        //Given
        final ItemsOnOffer itemsOnOffer = new ItemsOnOffer();
        final Item coke = new Item("coke", BigDecimal.valueOf(1));
        final Item apple = new Item("apple", BigDecimal.valueOf(2));

        //When
        itemsOnOffer.addOfferToItem(coke, new ThreeForTwo());
        itemsOnOffer.addOfferToItem(apple, new TwoForOnePound());

        //Then
        assertThat(itemsOnOffer.getOfferForItem(coke), is(CoreMatchers.not(Optional.empty())));
        assertThat(itemsOnOffer.getOfferForItem(coke).get(), is(instanceOf(ThreeForTwo.class)));
        assertThat(itemsOnOffer.getOfferForItem(apple), is(CoreMatchers.not(Optional.empty())));
        assertThat(itemsOnOffer.getOfferForItem(apple).get(), is(instanceOf(TwoForOnePound.class)));
    }
}

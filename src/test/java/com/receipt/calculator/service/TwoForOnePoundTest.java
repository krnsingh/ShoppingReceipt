package com.receipt.calculator.service;

import com.receipt.calculator.model.Item;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwoForOnePoundTest {


    @Test
    public void quantityOfOneShouldSavePriceOfZero() {
        //Given
        final Offer twoForOnePound = new TwoForOnePound();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.80);
        final Float totalQuantity = 1f;
        final Item item = new Item("Coke 500ml bottle", pricePerUnit);

        //When
        final BigDecimal savings = twoForOnePound.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(BigDecimal.valueOf(0.0).setScale(2)));
    }

    @Test
    public void quantityOfTwoShouldSavePriceOfOne() {
        //Given
        final Offer twoForOnePound = new TwoForOnePound();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.80);
        final Float totalQuantity = 2f;
        final Item item = new Item("Coke 500ml bottle", pricePerUnit);

        //When
        final BigDecimal savings = twoForOnePound.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(BigDecimal.valueOf(0.60).setScale(2)));
    }

    @Test
    public void quantityOfThreeShouldSavePriceOfOne() {
        //Given
        final Offer twoForOnePound = new TwoForOnePound();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.80);
        final Float totalQuantity = 3f;
        final Item item = new Item("Coke 500ml bottle", pricePerUnit);

        //When
        final BigDecimal savings = twoForOnePound.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(BigDecimal.valueOf(0.60).setScale(2)));
    }

    @Test
    public void quantityOfFourShouldSavePriceOfTwo() {
        //Given
        final Offer twoForOnePound = new TwoForOnePound();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.80);
        final Float totalQuantity = 4f;
        final Item item = new Item("Coke 500ml bottle", pricePerUnit);

        //When
        final BigDecimal savings = twoForOnePound.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(BigDecimal.valueOf(1.20).setScale(2)));
    }

}

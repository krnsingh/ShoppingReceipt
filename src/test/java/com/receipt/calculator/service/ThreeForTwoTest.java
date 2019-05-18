package com.receipt.calculator.service;

import com.receipt.calculator.Item;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThreeForTwoTest {

    @Test
    public void quantityOfThreeShouldSavePriceOfOne() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(1.0);
        final Float totalQuantity = 3f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit));
    }

    @Test
    public void quantityOfSixShouldSavePriceOfTwo() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(2.0);
        final Float totalQuantity = 6f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit.multiply(BigDecimal.valueOf(2))));
    }

    @Test
    public void quantityOfNineShouldSavePriceOfThree() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(2.0);
        final Float totalQuantity = 9f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit.multiply(BigDecimal.valueOf(3))));
    }

    @Test
    public void quantityOfTenShouldSavePriceOfThree() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(2.0);
        final Float totalQuantity = 10f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit.multiply(BigDecimal.valueOf(3))));
    }

    @Test
    public void quantityOfElevenShouldSavePriceOfThree() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(2.0);
        final Float totalQuantity = 11f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit.multiply(BigDecimal.valueOf(3))));
    }

    @Test
    public void quantityOfTwelveShouldSavePriceOfFour() {
        //Given
        final Offer threeForTwo = new ThreeForTwo();
        final BigDecimal pricePerUnit = BigDecimal.valueOf(2.0);
        final Float totalQuantity = 12f;
        final Item item = new Item("Coke 330ml", pricePerUnit);

        //When
        final BigDecimal savings = threeForTwo.calculateSaving(item, totalQuantity);

        //Then
        assertThat(savings, is(pricePerUnit.multiply(BigDecimal.valueOf(4))));
    }

}

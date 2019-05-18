package com.receipt.calculator;

import com.receipt.calculator.exception.InvalidItemNameException;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ItemTest {

    @Test
    public void itemInitializationWithValidName() {
        //Given
        final String itemName = "Coke";
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.50);

        //When
        final Item item = new Item(itemName, pricePerUnit);

        //Then
        assertThat(item.getName(), is(itemName));
        assertThat(item.getPricePerUnit(), is(pricePerUnit));
    }

    @Test(expected = InvalidItemNameException.class)
    public void itemInitializationWithEmptyName() {
        //Given
        final String itemName = "";
        final BigDecimal pricePerUnit = BigDecimal.valueOf(1.50);

        //When
        final Item item = new Item(itemName, pricePerUnit);

        //Then
        //throws InvalidItemNameException
    }

    @Test(expected = InvalidItemNameException.class)
    public void itemInitializationWithNullName() {
        //Given
        final String itemName = null;
        final BigDecimal pricePerUnit = BigDecimal.valueOf(1.50);

        //When
        final Item item = new Item(itemName, pricePerUnit);

        //Then
        //throws InvalidItemNameException
    }


}

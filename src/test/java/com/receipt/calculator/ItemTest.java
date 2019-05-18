package com.receipt.calculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ItemTest {


    @Test
    public void itemCreationWorks() {
        //Given
        final String itemName = "Coke";
        final BigDecimal pricePerUnit = BigDecimal.valueOf(0.50);

        //When
        final Item item = new Item(itemName, pricePerUnit);

        //Then
        assertThat(item.getName(), is(itemName));
        assertThat(item.getPricePerUnit(), is(pricePerUnit));
    }


}

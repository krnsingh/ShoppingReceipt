package com.receipt.calculator;

import java.math.BigDecimal;

public class Item {

    private String name;
    private BigDecimal pricePerUnit;

    public Item(String name, BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }
}

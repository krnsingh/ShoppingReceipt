package com.receipt.calculator;

import com.receipt.calculator.exception.InvalidItemNameException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class Item {

    private String name;
    private BigDecimal pricePerUnit;

    public Item(final String name, final BigDecimal pricePerUnit) {
        if(StringUtils.isAllEmpty(name))
            throw new InvalidItemNameException();
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

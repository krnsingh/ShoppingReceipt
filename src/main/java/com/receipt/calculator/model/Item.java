package com.receipt.calculator.model;

import com.receipt.calculator.exception.InvalidItemNameException;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private final String name;
    private final BigDecimal pricePerUnit;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}

package com.receipt.calculator.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ReceiptItem {

    private final String label;
    private final BigDecimal amount;

    public ReceiptItem(final String label, final BigDecimal amount) {
        this.label = label;
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItem that = (ReceiptItem) o;
        return label.equals(that.label) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, amount);
    }
}

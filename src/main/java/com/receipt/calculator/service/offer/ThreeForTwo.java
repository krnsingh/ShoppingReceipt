package com.receipt.calculator.service.offer;

import com.receipt.calculator.model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ThreeForTwo implements Offer {

    @Override
    public BigDecimal calculateSaving(final Item item, final Float quantity) {
        final BigDecimal savingFactor = BigDecimal.valueOf(quantity / 3).setScale(0, RoundingMode.DOWN);
        return savingFactor.multiply(item.getPricePerUnit()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String receiptLabel() {
        return "3 for 2";
    }

}

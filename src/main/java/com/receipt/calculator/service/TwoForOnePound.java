package com.receipt.calculator.service;

import com.receipt.calculator.model.Item;

import java.math.BigDecimal;

public class TwoForOnePound implements Offer {

    @Override
    public BigDecimal calculateSaving(final Item item, final Float quantity) {
        float quantityForSaving = quantity - (quantity % 2);
        final BigDecimal costAfterSaving = BigDecimal.valueOf(quantityForSaving / 2);
        final BigDecimal costBeforeSaving = BigDecimal.valueOf(quantityForSaving).multiply(item.getPricePerUnit());
        return costBeforeSaving.subtract(costAfterSaving);
    }

    @Override
    public String receiptLabel() {
        return "2 for £1";
    }

}

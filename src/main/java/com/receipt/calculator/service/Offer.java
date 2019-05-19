package com.receipt.calculator.service;

import com.receipt.calculator.model.Item;

import java.math.BigDecimal;

public interface Offer {

    BigDecimal calculateSaving(Item item, Float quantity);
    String receiptLabel();
}

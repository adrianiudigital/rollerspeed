package com.rollerspeed.models.enums;

public enum PaymentMethod {

    CASH("Cash"),
    CARD("Card"),
    TRANSFER("Bank Transfer"),
    ONLINE_PAYMENT("Online Payment");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

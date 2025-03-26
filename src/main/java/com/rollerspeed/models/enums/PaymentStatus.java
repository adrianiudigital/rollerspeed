package com.rollerspeed.models.enums;

public enum PaymentStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    REJECTED("Rejected");

    private final String displayName;

    PaymentStatus(String displayName) {
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

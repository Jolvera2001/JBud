package com.jolvera.jbud.domain.enums;

public enum RecurrencePattern {
    DAILY("Daily"),
    WEEKLY("Weekly"),
    BIWEEKLY("Biweekly"),
    MONTHLY("Monthly"),
    QUARTERLY("Quarterly"),
    SEMI_ANNUAL("Semi-annual"),
    ANNUAL("Annual");

    private final String displayName;

    RecurrencePattern(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

package com.jolvera.jbud.domain;

import com.jolvera.jbud.domain.abstracts.RecurringExpense;
import com.jolvera.jbud.domain.enums.RecurrencePattern;
import com.jolvera.jbud.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Income extends RecurringExpense {
    private String source;
    private boolean isGuaranteed;
    private String notes;

    public Income(
            UUID id,
            String description,
            BigDecimal amount,
            LocalDate startDate,
            TransactionType type,
            RecurrencePattern recurrencePattern,
            String source,
            boolean isGuaranteed,
            String notes
    ) {
        super(id, description, amount, startDate, type, recurrencePattern);
        this.source = source;
        this.isGuaranteed = isGuaranteed;
        this.notes = notes;
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public boolean isGuaranteed() { return isGuaranteed; }
    public void setGuaranteed(boolean isGuaranteed) { this.isGuaranteed = isGuaranteed; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

package com.jolvera.jbud.domain.abstracts;

import com.jolvera.jbud.domain.enums.RecurrencePattern;
import com.jolvera.jbud.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public abstract class RecurringExpense {
    private UUID id;
    private String description;
    private BigDecimal amount;
    private LocalDate startDate;
    private boolean active;
    private TransactionType type;
    private RecurrencePattern recurrencePattern;


    public LocalDate getNextOccurrenceDate() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

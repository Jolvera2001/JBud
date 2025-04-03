package com.jolvera.jbud.domain;

import com.jolvera.jbud.domain.abstracts.RecurringExpense;
import com.jolvera.jbud.domain.enums.RecurrencePattern;
import com.jolvera.jbud.domain.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Expense extends RecurringExpense {
    private String payee;
    private String paymentMethod;
    private boolean autoRenewal;
    private String notes;

    public Expense(
            UUID id,
            String description,
            BigDecimal amount,
            LocalDate startDate,
            TransactionType type,
            RecurrencePattern recurrencePattern,
            String payee,
            String paymentMethod,
            boolean autoRenewal,
            String notes
    ) {
        super(id, description, amount, startDate, type, recurrencePattern);
        this.payee = payee;
        this.paymentMethod = paymentMethod;
        this.autoRenewal = autoRenewal;
        this.notes = notes;
    }
}

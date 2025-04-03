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

    public String getPayee() { return payee; }
    public void setPayee(String payee) { this.payee = payee; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public boolean isAutoRenewal() { return autoRenewal; }
    public void setAutoRenewal(boolean autoRenewal) { this.autoRenewal = autoRenewal; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

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

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public RecurrencePattern getRecurrencePattern() { return recurrencePattern; }
    public void setRecurrencePattern(RecurrencePattern pattern) { this.recurrencePattern = pattern; }
}

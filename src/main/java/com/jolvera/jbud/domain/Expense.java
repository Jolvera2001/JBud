package com.jolvera.jbud.domain;

import com.jolvera.jbud.domain.abstracts.RecurringExpense;

public class Expense extends RecurringExpense {
    private String payee;
    private String paymentMethod;
    private boolean autoRenewal;
    private String notes;
}

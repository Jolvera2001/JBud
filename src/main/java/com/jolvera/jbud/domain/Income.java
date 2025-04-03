package com.jolvera.jbud.domain;

import com.jolvera.jbud.domain.abstracts.RecurringExpense;

public class Income extends RecurringExpense {
    private String source;
    private boolean isGuaranteed;
    private String notes;
}

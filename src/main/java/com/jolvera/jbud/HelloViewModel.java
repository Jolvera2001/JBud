package com.jolvera.jbud;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HelloViewModel {
    private final StringProperty transactionName = new SimpleStringProperty();
    private final StringProperty amount = new SimpleStringProperty("0.00");
    private final StringProperty status = new SimpleStringProperty();

    public StringProperty getTransactionName() {
        return transactionName;
    }

    public StringProperty getAmount() {
        return amount;
    }

    public StringProperty getStatus() {
        return status;
    }

    public void submitTransaction() {
        transactionName.set(getTransactionName().get());
        amount.set(getAmount().get());
        status.set("Submitted");
    }
}

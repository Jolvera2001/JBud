package com.jolvera.jbud;

import com.jolvera.jbud.models.Transaction;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloViewModel {
    private final StringProperty transactionName = new SimpleStringProperty();
    private final StringProperty amount = new SimpleStringProperty("0.00");
    private final StringProperty status = new SimpleStringProperty();

    private final SimpleObjectProperty<ObservableList<Transaction>> transactionListProperty =
            new SimpleObjectProperty<>(FXCollections.observableArrayList());

    public HelloViewModel() {
        populateList();
    }

    private void populateList() {
        transactionListProperty.set(FXCollections.observableArrayList(
                new Transaction("Movies", 23.25),
                new Transaction("Groceries", 200.24),
                new Transaction("Makeup", 5.25)
        ));
    }

    public SimpleObjectProperty<ObservableList<Transaction>> getTransactionListProperty() {
        return transactionListProperty;
    }

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
        Transaction newTransaction = new Transaction(
                transactionName.get(),
                Double.parseDouble(amount.get())
        );

        var list = transactionListProperty.get();
        list.add(newTransaction);
        clear();
    }

    public void clear() {
        transactionName.set("");
        amount.set("");
    }
}

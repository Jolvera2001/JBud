package com.jolvera.jbud.components;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class TransactionForm extends GridPane {
    public TransactionForm(
            StringProperty nameProperty,
            StringProperty amountProperty,
            StringProperty statusProperty,
            Runnable onSubmit
    ) {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));

        Text transactionTitle = new Text("New Transaction");
        Text statusText = new Text();
        add(transactionTitle, 0, 0, 2, 1);
        add(statusText, 1, 0, 1, 1);

        Label transactionLabel = new Label("Transaction Name:");
        Label amountLabel = new Label("Amount:");
        add(transactionLabel, 0, 1);
        add(amountLabel, 0, 2);

        TextField nameTextField = new TextField();
        TextField amountTextField = new TextField();
        add(nameTextField, 1, 1);
        add(amountTextField, 1, 2);

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> onSubmit.run());
        add(submitButton, 1, 3, 2, 1);

        nameTextField.textProperty().bindBidirectional(nameProperty);
        amountTextField.textProperty().bindBidirectional(amountProperty);
        statusText.textProperty().bindBidirectional(statusProperty);
    }
}

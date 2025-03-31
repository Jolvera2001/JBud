package com.jolvera.jbud;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class HelloView extends VBox {
    private final HelloViewModel viewModel;

    public HelloView() {
        this.viewModel = new HelloViewModel();

        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0));

        TransactionForm transactionForm = new TransactionForm(
                viewModel.getTransactionName(),
                viewModel.getAmount(),
                viewModel.getStatus(),
                viewModel::submitTransaction
        );
        transactionForm.setMaxHeight(USE_PREF_SIZE);

        getChildren().addAll(transactionForm);
    }
}


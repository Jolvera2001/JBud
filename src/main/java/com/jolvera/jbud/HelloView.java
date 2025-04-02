package com.jolvera.jbud;

import com.jolvera.jbud.components.TransactionForm;
import com.jolvera.jbud.models.Transaction;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloView extends VBox {
    private final HelloViewModel viewModel;

    public HelloView() {
        this.viewModel = new HelloViewModel();

        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0));

        HBox hbox = new HBox();

        ListView<Transaction> transactionListView = new ListView<>();
        transactionListView.itemsProperty().bind(viewModel.getTransactionListProperty());

        TransactionForm transactionForm = new TransactionForm(
                viewModel.getTransactionName(),
                viewModel.getAmount(),
                viewModel.getStatus(),
                viewModel::submitTransaction
        );
        transactionForm.setMaxHeight(USE_PREF_SIZE);

        hbox.getChildren().addAll(transactionForm, transactionListView);
        getChildren().addAll(hbox);
    }
}


package components

import javafx.beans.property.StringProperty
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.scene.text.Text

class TransactionForm(
    name: StringProperty,
    amount: StringProperty,
    onSubmit: () -> Unit) : GridPane() {

        init {
            hgap = 10.0
            vgap = 10.0
            padding = Insets(25.0, 25.0, 25.0, 25.0)

            val transactionTitle = Text("New Transaction")
            add(transactionTitle, 0,0,2,1)

            var transactionLabel = Label("Transaction Name:")
            var amountLabel = Label("Amount:")
            add(amountLabel, 0,1)
            add(transactionLabel, 0,2)

            var nameTextField = TextField()
            var amountTextField = TextField()
            add(nameTextField, 1,1)
            add(amountTextField, 1,2)

            var submitButton = Button("Submit")
            submitButton.setOnAction { onSubmit() }
            add(submitButton, 1, 3, 2, 1)

            nameTextField.textProperty().bindBidirectional(name)
            amountTextField.textProperty().bindBidirectional(amount)
        }
}
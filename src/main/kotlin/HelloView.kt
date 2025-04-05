import com.jolvera.jbud.HelloViewModel
import com.jolvera.jbud.components.TransactionForm
import com.jolvera.jbud.models.Transaction
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.ListView
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class HelloView//        ListView<Transaction>() transactionView = ListView<Transaction>()
public constructor() : VBox() {
    private val viewModel = HelloViewModel()

    init {
        alignment = Pos.CENTER
        spacing = 20.0
        padding = Insets(20.0)

        var hbox = HBox()
        var form = TransactionForm(
            viewModel.transactionName,
            viewModel.amount,
            viewModel.status,
            viewModel::submitTransaction
        )

        hbox.children.add(form)
        children.add(hbox)
    }
}
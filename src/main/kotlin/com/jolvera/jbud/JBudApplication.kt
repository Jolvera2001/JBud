package com.jolvera.jbud

import com.jolvera.jbud.domain.DatabaseConnection
import com.jolvera.jbud.ui.views.DashboardView
import com.jolvera.jbud.ui.views.ExpensesView
import com.jolvera.jbud.ui.views.IncomeView
import com.jolvera.jbud.ui.views.ReportsView
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.ListView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class JBudApplication : Application() {
    override fun start(primaryStage: Stage?) {
        // module
        initKoin()

        primaryStage?.isMaximized = true

        val root = BorderPane()

        val navList = ListView<String>().apply {
            items.addAll("Dashboard", "Income", "Expenses", "Reports")
            prefWidth = 180.0
        }

        val contentArea = StackPane()
        navList.selectionModel.selectedItemProperty().addListener { _, oldValue, newValue ->
            if (oldValue != null && contentArea.children.isNotEmpty()) {
                when (contentArea.children[0]) {
                    is DashboardView -> (contentArea.children[0] as DashboardView).onRemove()
                    is IncomeView -> (contentArea.children[0] as IncomeView).onRemove()
                    is ExpensesView -> (contentArea.children[0] as ExpensesView).onRemove()
                    is ReportsView -> (contentArea.children[0] as ReportsView).onRemove()
                }
            }

            contentArea.children.clear()
            when (newValue) {
                "Dashboard" -> contentArea.children.add(DashboardView())
                "Income" -> contentArea.children.add(IncomeView())
                "Expenses" -> contentArea.children.add(ExpensesView())
                "Reports" -> contentArea.children.add(ReportsView())
            }
        }

        root.left = navList
        root.center = contentArea
        navList.selectionModel.select(0)

        val scene = Scene(root)
        primaryStage?.title = "JBud"
        primaryStage?.scene = scene
        primaryStage?.show()
    }
}
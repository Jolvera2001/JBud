package com.jolvera.jbud

import com.jolvera.jbud.ui.views.DashboardView
import com.jolvera.jbud.ui.views.ItemsView
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
            items.addAll("Dashboard", "Items")
            prefWidth = 180.0
        }

        val contentArea = StackPane()
        navList.selectionModel.selectedItemProperty().addListener { _, oldValue, newValue ->
            if (oldValue != null && contentArea.children.isNotEmpty()) {
                when (contentArea.children[0]) {
                    is DashboardView -> (contentArea.children[0] as DashboardView).onRemove()
                    is ItemsView -> (contentArea.children[0] as ItemsView).onRemove()
                }
            }

            contentArea.children.clear()
            when (newValue) {
                "Dashboard" -> contentArea.children.add(DashboardView())
                "Items" -> contentArea.children.add(ItemsView())
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
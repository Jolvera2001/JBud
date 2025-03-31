package com.jolvera.jbud;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HelloView extends VBox {
    private final HelloViewModel viewModel;

    public HelloView() {
        this.viewModel = new HelloViewModel();

        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0));

        Label welcomeLabel = new Label();
        Button helloButton = new Button("Hello");

        welcomeLabel.textProperty().bind(viewModel.getWelcomeText());

        helloButton.setOnAction(event -> viewModel.sayHello());

        getChildren().addAll(welcomeLabel, helloButton);
    }
}

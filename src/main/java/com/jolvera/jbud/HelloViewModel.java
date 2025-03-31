package com.jolvera.jbud;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HelloViewModel {
    private final StringProperty welcomeText = new SimpleStringProperty();

    public StringProperty getWelcomeText() {
        return welcomeText;
    }

    public void sayHello() {
        welcomeText.set("Welcome to JavaFX App! I'm JBud!");
    }
}

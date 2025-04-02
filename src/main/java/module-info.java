module com.jolvera.jbud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.jolvera.jbud to javafx.fxml;
    exports com.jolvera.jbud;
    exports com.jolvera.jbud.components;
    exports com.jolvera.jbud.models;
    opens com.jolvera.jbud.components to javafx.fxml;
}
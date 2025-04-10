module com.jolvera.jbud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires jdk.jshell;
    requires kotlinx.coroutines.javafx;
    requires kotlinx.coroutines.core;

    opens com.jolvera.jbud to javafx.fxml;
    exports com.jolvera.jbud;
}
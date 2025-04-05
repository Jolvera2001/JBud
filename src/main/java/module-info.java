module com.jolvera.jbud {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires jdk.jshell;

    opens com.jolvera.jbud to javafx.fxml;
    exports com.jolvera.jbud;
}
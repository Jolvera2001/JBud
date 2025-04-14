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

    requires java.sql;
    requires exposed.core;
    requires exposed.jdbc;
    requires exposed.dao;
    requires exposed.kotlin.datetime;

    requires koin.core.jvm;

    requires org.slf4j;
    requires jdk.jfr;
    requires fr.brouillard.oss.cssfx;

    opens com.jolvera.jbud to javafx.fxml;
    exports com.jolvera.jbud;
}
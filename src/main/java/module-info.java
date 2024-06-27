module dbrestaurant.dbrestaurant {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;

    opens dbrestaurant.dbrestaurant to javafx.fxml;
    exports dbrestaurant.dbrestaurant;
    exports dbrestaurant.dbrestaurant.controllers;
    opens dbrestaurant.dbrestaurant.controllers to javafx.fxml;
}
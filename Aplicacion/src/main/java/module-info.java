module com.espol.proyectobd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires  javafx.graphics;
    requires java.sql;

    opens com.espol.proyectobd to javafx.fxml;
    exports com.espol.proyectobd;
    opens com.espol.controller to javafx.fxml;
    exports com.espol.controller;
    opens com.espol.model to javafx.fxml;
    exports com.espol.model;
    
}

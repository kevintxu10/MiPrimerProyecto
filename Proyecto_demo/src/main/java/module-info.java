module org.example.proyecto_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    opens org.example.proyecto_demo to javafx.fxml;
    exports org.example.proyecto_demo;
}
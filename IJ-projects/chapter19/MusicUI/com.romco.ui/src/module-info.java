module com.romco.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.romco.db;
    requires com.romco.common;
    
    exports com.romco.ui to javafx.graphics, javafx.fxml;
    opens com.romco.ui to javafx.fxml;
}
module com.romco.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.romco.db;
    
    exports com.romco.ui to javafx.graphics, javafx.fxml;
    opens com.romco.ui to javafx.fxml;
}
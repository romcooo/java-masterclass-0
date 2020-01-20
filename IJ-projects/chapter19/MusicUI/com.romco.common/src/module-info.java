module com.romco.common {
    requires javafx.base;
    
    exports com.romco.common;
    
    opens com.romco.common to javafx.base;
}
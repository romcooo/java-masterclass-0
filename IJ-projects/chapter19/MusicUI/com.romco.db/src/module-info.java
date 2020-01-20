module com.romco.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires com.romco.common;
    
    exports com.romco.db;
}
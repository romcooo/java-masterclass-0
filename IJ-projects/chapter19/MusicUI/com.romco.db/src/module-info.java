module com.romco.db {
    requires java.sql;
    requires sqlite.jdbc;
    requires transitive com.romco.common;
    
    exports com.romco.db;
}
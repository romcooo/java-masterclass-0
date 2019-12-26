package com.romco;

import java.sql.*;

public class Main {
//    public static final String CONNECTION_STRING = "jdbc:sqlite:I:\\Git\\java-masterclass-0\\IJ-projects\\chapter19\\TestDB\\mydb\\testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\TestDB\\mydb\\testjava.db";
    public static final String DB_NAME = "testjava.db";
    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String SPACE = " ";
    public static final String CSPACE = ", ";


    public static void main(String[] args) {
//        try(Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\TestDB\\mydb\\testjava.db");
//            Statement statement = con.createStatement()) {
        try {
            Connection con = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = con.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "( " + COLUMN_NAME + " text, " + COLUMN_PHONE + " integer, " + COLUMN_EMAIL + " text)");
            
            statement.execute("INSERT INTO " + TABLE_CONTACTS + SPACE + )
//            con.setAutoCommit(false);
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
//                    "(name TEXT, phone INTEGER, email TEXT)");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " values('Aaron', 123124, 'aa@ron.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " values('Bert', 123125, 'be@rt.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                    " values('Carl', 123126, 'ca@rl.com')");

            statement.execute("SELECT * FROM contacts");

            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close();
            statement.close();
            con.close();
        } catch(SQLException e) {
            System.out.println("Something went wrong with sql: " + e.getMessage());
            
        }
    }
}

package com.romco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
//        try(Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\TestDB\\mydb\\testjava.db");
//            Statement statement = con.createStatement()) {
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\TestDB\\mydb\\testjava.db");
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
            statement.close();
            con.close();
        } catch(SQLException e) {
            System.out.println("Something went wrong with sql: " + e.getMessage());
            
        }
    }
}

package com.romco.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\Music\\mydb\\" + DB_NAME;
    
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;
    
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;
    
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;
    
    public static final String
    
    private Connection con;
    
    public boolean open() {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("Database opened: " + CONNECTION_STRING);
            return true;
        } catch (SQLException e ) {
            System.out.println("couldn't connect to DB");
            e.printStackTrace();
            return false;
        }
    }
    
    public void close() {
        try {
            if(con != null) {
                con.close();
                System.out.println("Database closed.");
            }
        } catch(SQLException e) {
            System.out.println("couldn't close connection");
            e.printStackTrace();
        }
    }
    
    public List<Artist> queryArtists(int sortOrder) {
//        Statement statement = null;
//        ResultSet resultSet = null;
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        
        try(Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)) {
            
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                artists.add(
                        new Artist(
                                resultSet.getInt(INDEX_ARTISTS_ID),
                                resultSet.getString(INDEX_ARTISTS_NAME)));
            }
            return artists;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

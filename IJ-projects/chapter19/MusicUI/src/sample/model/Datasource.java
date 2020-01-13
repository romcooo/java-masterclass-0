package sample.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    //<editor-fold desc="Constants for DB">
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\roman.stubna\\OneDrive - Home Credit International a.s\\Personal\\git\\Java_masterclass\\IJ-projects\\chapter19\\MusicUI\\mydb\\" + DB_NAME;
    
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
    
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;
    
    public static final String QUERY_ABUMS_BY_ARTIST_START =
            " SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +" FROM " + TABLE_ALBUMS +" INNER JOIN "
            + TABLE_ARTISTS + " ON " + TABLE_ALBUMS +"." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "."
            + COLUMN_ARTISTS_ID + " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME +" = \"";
    
    public static final String SONG_TITLE_PLACEHOLDER = "%SONGTITLE%";
    public static final String QUERY_ARTIST_FOR_SONG_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", "
                    + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME
                    + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                " FROM " + TABLE_SONGS + "" +
                " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
                " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
                " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"" + SONG_TITLE_PLACEHOLDER + "\"";
    
    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;
    
    //SELECT name, album, track FROM artist_list WHERE title = "title";
    
    public static final String QUERY_VIEW_SONG_INFO =
            "SELECT " + COLUMN_ARTISTS_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = \"";
    
    public static final String QUERY_VIEW_SONG_INFO_PREP =
            "SELECT " + COLUMN_ARTISTS_NAME + ", " + COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONG_TITLE + " = ?";
    
    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTISTS_NAME + ") VALUES (?)";
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUM_NAME +
            ", " + COLUMN_ALBUM_ARTIST + ") VALUES (?,?)";
    public static final String INSERT_SONG = "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONG_TRACK + ", " +
            COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES (?,?,?)";
    
    public static final String QUERY_ARTIST_EXISTS = "SELECT " + COLUMN_ARTISTS_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTISTS_NAME + " = ?";
    public static final String QUERY_ALBUM_EXISTS = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";
    public static final String QUERY_ALBUMS_BY_ARTIST_ID = "SELECT * FROM " + TABLE_ALBUMS +
            " WHERE " + COLUMN_ALBUM_ARTIST + " = ? ORDER BY " + COLUMN_ALBUM_NAME + " COLLATE NOCASE";
    public static final String UPDATE_ARTIST_NAME_BY_ARTIST_ID = "UPDATE " + TABLE_ARTISTS + " SET " +
            COLUMN_ARTISTS_NAME + " = ? WHERE " + COLUMN_ARTISTS_ID + " = ?";
    
    //</editor-fold>
    
    private Connection con;
    
    private PreparedStatement querySongInfoView, insertArtist, insertAlbum, insertSong;
    private PreparedStatement queryArtistExists, queryAlbumExists;
    private PreparedStatement queryAlbumsByArtistId;
    private PreparedStatement updateArtistNameByArtistId;
    
    private static Datasource instance = new Datasource();
    private Datasource() {
    }
    
    public static Datasource getInstance() {
        return instance;
    }
    
    public boolean open() {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            
            querySongInfoView = con.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            
            insertArtist = con.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertAlbum = con.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertSong = con.prepareStatement(INSERT_SONG);
            
            queryArtistExists = con.prepareStatement(QUERY_ARTIST_EXISTS);
            queryAlbumExists = con.prepareStatement(QUERY_ALBUM_EXISTS);
    
            queryAlbumsByArtistId = con.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
    
            updateArtistNameByArtistId = con.prepareStatement(UPDATE_ARTIST_NAME_BY_ARTIST_ID);
            
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
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertArtist != null) {
                insertArtist.close();
            }
            if (insertAlbum != null) {
                insertAlbum.close();
            }
            if (insertSong != null) {
                insertSong.close();
            }
            if (queryAlbumExists != null) {
                queryAlbumExists.close();
            }
            if (queryArtistExists != null) {
                queryArtistExists.close();
            }
            if (queryAlbumsByArtistId != null) {
                queryAlbumsByArtistId.close();
            }
            if (updateArtistNameByArtistId != null) {
                updateArtistNameByArtistId.close();
            }
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
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTISTS_NAME);
            sb.append(" COLLATE NOCASE ");
            sb.append(sortOrder == ORDER_BY_DESC ? "DESC" : "ASC");
        }
        
        try(Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {
            
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTISTS_ID));
                artist.setName(resultSet.getString(INDEX_ARTISTS_NAME));
                artists.add(artist);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return artists;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Album> queryAlbumForArtistId(int artistId) {
        try {
            queryAlbumsByArtistId.setInt(1, artistId);
            ResultSet resultSet = queryAlbumsByArtistId.executeQuery();
            
            List<Album> albums = new ArrayList<>();
            while (resultSet.next()) {
                Album album = new Album();
                album.setId(resultSet.getInt(1));
                album.setName(resultSet.getString(2));
                album.setArtist(artistId);
                albums.add(album);
            }
            return albums;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // SELECT albums.name from albums INNER JOIN artists ON albums.artist = ARTISTS._id where artists.name = input order by albums.name collate nocase asc
    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY_ABUMS_BY_ARTIST_START)
                .append(artistName)
                .append("\"");
        if (sortOrder != ORDER_BY_NONE) {
            sb
                    .append(" ORDER BY ")
                    .append(TABLE_ALBUMS)
                    .append(".")
                    .append(COLUMN_ARTISTS_NAME)
                    .append(" COLLATE NOCASE ")
                    .append(sortOrder == ORDER_BY_DESC ? "DESC" : "ASC");
        }
        List<String> albumNames = new ArrayList<>();
    
        try(Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {
            while (resultSet.next()) {
                System.out.println("adding " + resultSet.getString(1));
                albumNames.add(resultSet.getString(1));
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        System.out.println(sb.toString());
        return albumNames;
    }
    
    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {
        
        String replacedQuery = QUERY_ARTIST_FOR_SONG_START.replaceAll(SONG_TITLE_PLACEHOLDER, songName);
        
        StringBuilder sb = new StringBuilder(replacedQuery);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + TABLE_ALBUMS + "." + INDEX_ALBUM_NAME + "COLLATE NOCASE ");
            sb.append(sortOrder == ORDER_BY_DESC ? "DESC" : "ASC");
        }
        sb.append(";");
        System.out.println(sb.toString());
        
        List<SongArtist> songArtists = new ArrayList<>();
    
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sb.toString());
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist(
                        resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)
                );
                System.out.println("adding: " + resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
                songArtists.add(songArtist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
        return songArtists;
    }
    
    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;
    
        try (Statement statement = con.createStatement()) {
            ResultSet results = statement.executeQuery(sql);
            
            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table is %s\n", i, meta.getColumnName(i));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getCount(String table) {
        String sql = "SELECT COUNT(1) AS count, MIN(_id) AS min_id, MAX(_id) AS max_id FROM " + table;
    
        try (Statement statement = con.createStatement()) {
            ResultSet results = statement.executeQuery(sql);
            int count = results.getInt("count");
            int min = results.getInt("min_id");
            int max = results.getInt("max_id");
            System.out.format("count is: %d, min: %d, max: %d \n", count, min, max);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public boolean createViewForSongArtists() {
        try (Statement statement = con.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<SongArtist> querySongInfoView(String songTitle) {
        
        try {
            querySongInfoView.setString(1, songTitle);
            ResultSet resultSet = querySongInfoView.executeQuery();
    
            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private int insertArtist(String artistName) throws SQLException {
        queryArtistExists.setString(1, artistName);
        ResultSet resultSet = queryArtistExists.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            //insert
            insertArtist.setString(1, artistName);
            int affectedRows = insertArtist.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist.");
            }
            
            ResultSet generatedKeys = insertArtist.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }
    
    private int insertAlbum(String name, int artistId) throws SQLException {
        queryAlbumExists.setString(1, name);
        ResultSet resultSet = queryAlbumExists.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            //insert
            insertAlbum.setString(1, name);
            insertAlbum.setInt(2, artistId);
            int affectedRows = insertAlbum.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album.");
            }
            
            ResultSet generatedKeys = insertAlbum.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }
    
    public boolean updateArtistByArtistId(String newArtistName, int artistId) {
        try {
            updateArtistNameByArtistId.setString(1, newArtistName);
            updateArtistNameByArtistId.setInt(2, artistId);
            int affectedRecords = updateArtistNameByArtistId.executeUpdate();
            
            return affectedRecords == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void insertSong(String songTitle, String artistName, String albumName, int songTrackNumber) {
        try {
            con.setAutoCommit(false);
            
            int artistId = insertArtist(artistName);
            int albumId = insertAlbum(albumName, artistId);
            
            insertSong.setInt(1, songTrackNumber);
            insertSong.setString(2, songTitle);
            insertSong.setInt(3, albumId);
            System.out.println(INSERT_SONG);
            
            int affectedRows = insertSong.executeUpdate();
            if (affectedRows == 1) {
                con.commit();
                SongArtist sa = querySongInfoView(songTitle).get(0);
                System.out.format("Song committed successfully: artist = %s \n album = %s \n track: %d\n",
                                  sa.getArtistName(), sa.getAlbumName(), sa.getTrack() );
            } else {
                throw new SQLException("Song insert failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("Performing rollback");
                con.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy...");
                e2.printStackTrace();
            }
        } finally {
            try {
                System.out.println("Resetting to default commit behaviour");
                con.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("Couldn't reset auto-commit.");
                e3.printStackTrace();
            }
        }
        
    }
}

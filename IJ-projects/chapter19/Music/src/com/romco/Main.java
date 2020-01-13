package com.romco;

import com.romco.model.Artist;
import com.romco.model.Datasource;
import com.romco.model.SongArtist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("can't open datasource");
            return;
        }
    
        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_ASC);
        
        if (artists != null) {
            for (Artist artist : artists) {
                System.out.println("ID = " + artist.getId() + ", name: " + artist.getName());
            }
        }
    
        datasource.queryAlbumsForArtist("Oasis", Datasource.ORDER_BY_DESC);
    
        List<SongArtist> songArtists = datasource.queryArtistsForSong("Little By Little (Live)", Datasource.ORDER_BY_NONE);
        
        if (songArtists == null) {
            System.out.println("asd");
            return;
        }
        
        for (SongArtist artist : songArtists) {
            System.out.println("Artist name: " + artist.getArtistName());
            System.out.println("Album name: " + artist.getAlbumName());
            System.out.println("Track: " + artist.getTrack());
        }
        
        datasource.querySongsMetadata();
        
        int songCount = datasource.getCount(Datasource.TABLE_SONGS);
    
        System.out.println("Number of songs in table is: " + songCount);
        
        datasource.createViewForSongArtists();
    
        System.out.println("====================");
        
        songArtists = datasource.querySongInfoView("Little By Little (Live)");
        for (SongArtist artist : songArtists) {
            System.out.println("Artist name: " + artist.getArtistName());
            System.out.println("Album name: " + artist.getAlbumName());
            System.out.println("Track: " + artist.getTrack());
        }
    
        //new artist, new album, new song
//        datasource.insertSong("Riverman", "Noel Gallagher's High Flying Birds",
//                              "Chasing Yesterday", 1);
        
        //existing artist, new album, new song
//        datasource.insertSong("Live Forever", "Oasis", "Definitely Maybe" , 1);
        
        //existing artist, existing album, new song
        datasource.insertSong("Supersonic", "Oasis",
                              "Definitely Maybe", 2);
        
//        songArtists = datasource.querySongInfoView("Riverman");
//        for (SongArtist artist : songArtists) {
//            System.out.println("Artist name: " + artist.getArtistName());
//            System.out.println("Album name: " + artist.getAlbumName());
//            System.out.println("Track: " + artist.getTrack());
//        }
        datasource.close();
    
    }
}

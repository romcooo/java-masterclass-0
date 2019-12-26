package com.romco;

import com.romco.model.Artist;
import com.romco.model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("can't open datasource");
            return;
        }
    
        List<Artist> artists = datasource.queryArtists(1);
        
        if (artists != null) {
            for (Artist artist : artists) {
                System.out.println("ID = " + artist.getId() + ", name: " + artist.getName());
            }
        }
        
        datasource.close();
        
        
        
    }
}

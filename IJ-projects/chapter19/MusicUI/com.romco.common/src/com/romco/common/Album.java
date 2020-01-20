package com.romco.common;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Album {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty artist;
    
    public Album(int id, String name, String artist) {
        this.id.set(id);
        this.name.set(name);
        this.artist.set(artist);
    }
    
    public Album() {
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        artist = new SimpleStringProperty();
    }
    
    public int getId() {
        return id.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setName(String name) {
        this.name.set(name);
    }
    
    public String getArtist() {
        return artist.get();
    }
    
    public void setArtist(String artist) {
        this.artist.set(artist);
    }
    public void setArtist(int artistId) {
        this.artist.set(Integer.toString(artistId));
    }
}

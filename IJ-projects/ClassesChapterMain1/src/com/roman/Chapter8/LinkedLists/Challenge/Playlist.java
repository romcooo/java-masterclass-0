package com.roman.Chapter8.LinkedLists.Challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private LinkedList<Song> playlist;
    private ArrayList<Album> ownedAlbums;
    private String name;

    public Playlist(final String name) {
        this.name = name;
        this.ownedAlbums = new ArrayList<>();
        this.playlist = new LinkedList<>();
    }

    public boolean addAlbum(String albumName) {
        if (getAlbum(albumName) == null) {
            this.ownedAlbums.add(new Album(albumName));
            System.out.println("Playlist - Album added: " + albumName);
            return true;
        }
        System.out.println("Playlist - album with such name already exists");
        return false;
    }

    /*public boolean addSong(String songName, String songDuration, String albumName) {
        Album album = getAlbum(albumName);
        if (album != null) {
            return album.addSong(songName, songDuration);
        } else {
            addAlbum(albumName);
            album = getAlbum(albumName);
            return album.addSong(songName, songDuration);
        }
    }*/

    public boolean addSong(String songTitle) {
        for (Album album:ownedAlbums) {
            if (album.containsSong(songTitle)) {
                this.playlist.add(album.getSong(songTitle));
                return true;
            }
        }
        System.out.println("Playlist - song not owned");
        return false;
    }

    public Album getAlbum(String albumName) {
        for (Album album:ownedAlbums) {
            if (album.getName().equals(albumName)) {
                return album;
            }
        }
        return null;
    }

    public boolean isSongOwned(String songTitle) {
        for (Album album:ownedAlbums) {
            if (album.containsSong(songTitle)) {
                return true;
            }
        }
        return false;
    }

    public void printPlaylist(boolean withSongDuration) {
        int i = 0;
        for (Song song:playlist) {
            i++;
            System.out.print(i + ": " + song.getTitle());
            if (withSongDuration) {
                System.out.println(", " + song.getDurationString());
            } else {
                System.out.println();
            }
        }

        ListIterator<Song> songListIterator = playlist.listIterator();
        while (songListIterator.hasNext()) {
        }
    }


}

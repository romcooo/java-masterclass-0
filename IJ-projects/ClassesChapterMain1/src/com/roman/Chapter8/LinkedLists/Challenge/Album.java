package com.roman.Chapter8.LinkedLists.Challenge;

import java.time.Duration;
import java.util.ArrayList;

public class Album {
    private ArrayList<Song> songList;
    private String name;

    public Album(final String name) {
        this.songList = new ArrayList<>();
        this.name = name;
    }

    public Album(final String name, Song song) {
        this(name);
        this.songList.add(song);
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public String getName() {
        return name;
    }

    public boolean addSong(String songTitle, String durationString) {
        Song song = new Song(songTitle, durationString);
        if (!this.songList.contains(song)) {
            this.songList.add(song);
            return true;
        }
        return false;
    }

    public boolean removeSong(String songTitle) {
        Song songToRemove = getSong(songTitle);
        if(songToRemove != null) {
            this.songList.remove(songToRemove);
            return true;
        } else return false;
    }

    public Song getSong(String songTitle) {
        for (Song song:songList) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }

    public boolean containsSong(String songTitle) {
        if (getSong(songTitle) != null) {
            return true;
        }
        return false;
    }

    public void printAlbumTracks(boolean withDuration) {
        int i = 0;
        for (Song song:songList) {
            i++;
            System.out.print(i + ": " + song.getTitle());
            if(withDuration) {
                System.out.println(", " + song.getDurationString());
            } else {
                System.out.println();
            }
        }
    }
}

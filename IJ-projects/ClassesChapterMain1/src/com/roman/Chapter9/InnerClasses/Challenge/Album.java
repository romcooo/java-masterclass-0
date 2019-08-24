package com.roman.Chapter9.InnerClasses.Challenge;

import java.util.ArrayList;

public class Album {
    private SongList songList;
    private String name;

    private class SongList {
        private ArrayList<Song> songList;

        private SongList() {
            this.songList = new ArrayList<>();
        }

        private ArrayList<Song> getSongList() {
            return this.songList;
        }

        private boolean addSong(String songTitle, String durationString) {
            Song song = new Song(songTitle, durationString);
            if (!this.songList.contains(song)) {
                this.songList.add(song);
                return true;
            }
            return false;
        }

        private boolean removeSong(String songTitle) {
            Song songToRemove = getSong(songTitle);
            if(songToRemove != null) {
                this.songList.remove(songToRemove);
                return true;
            } else return false;
        }

        private Song getSong(String songTitle) {
            for (Song song:this.songList) {
                if (song.getTitle().equals(songTitle)) {
                    return song;
                }
            }
            return null;
        }

        private boolean containsSong(String songTitle) {
            return (this.getSong(songTitle) != null);
        }

        private void printAlbumTracks(boolean withDuration) {
            int i = 0;
            for (Song song:this.songList) {
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

    public Album(final String name) {
        this.songList = new SongList();
        this.name = name;
    }

    public ArrayList<Song> getSongList() {
        return this.songList.getSongList();
    }

    public String getName() {
        return name;
    }

    public boolean addSong(String songTitle, String durationString) {
        return this.songList.addSong(songTitle, durationString);
    }

    public boolean removeSong(String songTitle) {
        return this.songList.removeSong(songTitle);
    }

    public Song getSong(String songTitle) {
        return this.songList.getSong(songTitle);
    }

    public boolean containsSong(String songTitle) {
        return this.songList.containsSong(songTitle);
    }

    public void printAlbumTracks(boolean withDuration) {
        this.songList.printAlbumTracks(withDuration);
    }
}

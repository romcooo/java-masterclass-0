package com.roman.Chapter8.LinkedLists.Challenge;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private static String
            INSTRUCTION_INPUT_1 = "Choose an option: ",
            PLAYLIST_EMPTY = "Playlist is empty, nothing to play.",
            NOW_PLAYING = "Now playing: ";

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

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println(PLAYLIST_EMPTY);
            return;
        }

        printPlaylist(true);
        printInstructions();

        boolean programRunning = true;
        Scanner scanner = new Scanner(System.in);
        int choice;
        ListIterator<Song> playlistIterator = playlist.listIterator();
        boolean directionForward = true;

        System.out.println(NOW_PLAYING + playlistIterator.next().getTitleAndDurationString() );

        while (programRunning){
            System.out.print(INSTRUCTION_INPUT_1);
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    if (!directionForward && playlistIterator.hasNext()) {
                        playlistIterator.next();
                        directionForward = true;
                    }
                    if (playlistIterator.hasNext()) {
                        System.out.println("Skipping forward, now playing: " + playlistIterator.next().getTitleAndDurationString() );
                    } else {
                        System.out.println("Cannot skip forward, currently at last song.");
                    }
                    break;
                case 2:
                    if (directionForward && playlistIterator.hasPrevious()) {
                        playlistIterator.previous();
                        directionForward = false;
                    }
                    if (playlistIterator.hasPrevious()) {
                        System.out.println("Skipping backward, now playing: " + playlistIterator.previous().getTitleAndDurationString() );
                    } else {
                        System.out.println("Cannot skip backward, currently at first song.");
                    }
                    break;
                case 3:
                    if (directionForward && playlistIterator.hasPrevious()) {
                        playlistIterator.previous();
                        System.out.println("Replaying current song: " + playlistIterator.next().getTitleAndDurationString() );
                        directionForward = true;
                    }

                    break;
                case 4:
                    printPlaylist(true);
                    break;
                case 5:
                    if(directionForward && playlistIterator.hasPrevious()) {
                        playlistIterator.previous();
                        System.out.println("Removing current song: " + playlistIterator.next().getTitleAndDurationString() + ", now playing: " + playlistIterator.next().getTitleAndDurationString() );
                    } else {
                        System.out.println("Removing the last song in the playlist.");
                        playlistIterator.remove();
                    }
                    break;
                case 9:
                    programRunning = false;
                    System.out.println("Exiting playlist.");
                    break;
            }
        }


    }

    public void printPlaylist(boolean withSongDuration) {
        int i = 0;
        Duration playlistDuration = Duration.ofMillis(0);
        for (Song song:playlist) {
            i++;
            System.out.print(i + ": " + song.getTitle());
            if (withSongDuration) {
                System.out.println(", " + song.getDurationString());
            } else {
                System.out.println();
            }
            playlistDuration = playlistDuration.plus(song.getDuration());

        }
        System.out.println("Total playlist duration: " + PlaylistFormatter.getDurationString(playlistDuration));
    }

    private void printInstructions() {
        System.out.println("0 - Show Instructions;\n"
                + "1 - Skip to next song;\n"
                + "2 - Replay previous song;\n"
                + "3 - Replay current song;\n"
                + "4 - List songs in the playlist;\n"
                + "5 - Remove current song;"
                + "9 - Exit;\n");
    }

}

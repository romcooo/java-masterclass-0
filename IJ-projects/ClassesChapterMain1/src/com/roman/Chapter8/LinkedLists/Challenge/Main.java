package com.roman.Chapter8.LinkedLists.Challenge;

public class Main {
    public static void main(String[] args) {
        Playlist play = new Playlist("playlist 1");

        play.addAlbum("album 1");
        Album album1 = play.getAlbum("album 1");
        album1.addSong("Highway to Hell", "3:50");
        album1.addSong("Fire Your Guns", "2:58");
        album1.addSong("You Shook Me All Night Long", "4:16");
        album1.addSong("Thunderstruck", "3:46");

        play.addSong("Highway to Hell");
        play.addSong("Fire Your Guns");
        play.addSong("You Shook Me All Night Long");
        play.addSong("Thunderstruck");
        play.addSong("Back in Black");
        play.printPlaylist(true);

        play.play();
    }
}

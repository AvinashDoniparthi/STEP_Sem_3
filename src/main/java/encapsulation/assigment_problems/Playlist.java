package encapsulation.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSize) {
        if (maximumSize < 0) {
            throw new IllegalArgumentException("Maximum size cannot be negative");
        }
        songs = new String[maximumSize];
    }

    public boolean addSong(String title) {
        if (songCount == songs.length || title == null) {
            return false;
        }
        songs[songCount++] = title;
        return true;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(playlist.getSongs()));
        System.out.println("Song count: " + playlist.getSongCount());
    }
}
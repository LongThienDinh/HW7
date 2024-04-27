public class Song {
    private int duration;
    private String album;
    private String title;
    private String artist;

    public Song(String title, String artist, String album, int duration) {
        this.album = album;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }
    public String getAlbum() {
        return album;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }

}
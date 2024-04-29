public class Song {
    private Integer songId;
    private String title;
    private String artist;
    private String album;

    public Song(Integer songId, String title, String artist, String album) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    public Integer getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song(" + songId + "): Title = " + title + ", Artist = " + artist + ", Album = " + album;
    }
}

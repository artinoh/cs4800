import java.util.ArrayList;
import java.util.List;

public class SongServiceServer implements SongService {
    private List<Song> songs = new ArrayList<>();
    SongServiceServer(SongDatabaseInterface db) {
        songs = db.songs();
    }
    private void simulateServerCall() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {};
    }

    @Override
    public Song searchById(Integer songId) {
        simulateServerCall();
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateServerCall();
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        simulateServerCall();
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().toLowerCase().contains(artist.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateServerCall();
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().toLowerCase().contains(album.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }



}

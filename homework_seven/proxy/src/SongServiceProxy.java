import java.util.List;
import java.util.HashMap;

public class SongServiceProxy implements SongService {
    private final SongService songService;
    private final HashMap<Integer, Song> cachedSongsById = new HashMap<>();
    private final HashMap<String, List<Song>> cachedSongsByTitle = new HashMap<>();
    private final HashMap<String, List<Song>> cachedSongsByArtist = new HashMap<>();
    private final HashMap<String, List<Song>> cachedSongsByAlbum = new HashMap<>();

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song searchById(Integer songId) {
        if (cachedSongsById.containsKey(songId)) {
            return cachedSongsById.get(songId);
        }
        Song song = songService.searchById(songId);
        cachedSongsById.put(songId, song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (cachedSongsByTitle.containsKey(title)) {
            return cachedSongsByTitle.get(title);
        }
        List<Song> songs = songService.searchByTitle(title);
        cachedSongsByTitle.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        if (cachedSongsByArtist.containsKey(artist)) {
            return cachedSongsByArtist.get(artist);
        }
        List<Song> songs = songService.searchByArtist(artist);
        cachedSongsByArtist.put(artist, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (cachedSongsByAlbum.containsKey(album)) {
            return cachedSongsByAlbum.get(album);
        }
        List<Song> songs = songService.searchByAlbum(album);
        cachedSongsByAlbum.put(album, songs);
        return songs;
    }


}

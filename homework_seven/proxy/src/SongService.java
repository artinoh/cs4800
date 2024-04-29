import java.util.List;
public interface SongService {
    Song searchById(Integer songId);
    List<Song> searchByTitle(String title);
    List<Song> searchByArtist(String artist);
    List<Song> searchByAlbum(String album);
}

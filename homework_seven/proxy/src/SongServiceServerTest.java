import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SongServiceServerTest {

    private SongServiceServer service;
    private List<Song> songs;

    @BeforeEach
    public void setUp() {
        songs = new ArrayList<>();
        songs.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera"));
        songs.add(new Song(2, "Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV"));

        service = new SongServiceServer(new MockSongDatabase(songs));
    }

    @Test
    public void testSearchById_Found() {
        Song song = service.searchById(1);
        assertNotNull(song);
        assertEquals("Bohemian Rhapsody", song.getTitle());
    }

    @Test
    public void testSearchById_NotFound() {
        Song song = service.searchById(3);
        assertNull(song);
    }

    @Test
    public void testSearchByTitle() {
        List<Song> results = service.searchByTitle("Stairway");
        assertEquals(1, results.size());
        assertEquals("Stairway to Heaven", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitle_CaseInsensitive() {
        List<Song> results = service.searchByTitle("bOhEmIaN");
        assertEquals(1, results.size());
        assertEquals("Bohemian Rhapsody", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitle_NoMatch() {
        List<Song> results = service.searchByTitle("Nothing");
        assertTrue(results.isEmpty());
    }

    @Test
    public void testSearchByArtist() {
        List<Song> results = service.searchByArtist("Queen");
        assertEquals(1, results.size());
        assertEquals("Bohemian Rhapsody", results.get(0).getTitle());
    }

    @Test
    public void testSearchByArtist_MultipleMatches() {
        List<Song> results = service.searchByArtist("Led Zeppelin");
        assertEquals(1, results.size());
        assertEquals("Stairway to Heaven", results.get(0).getTitle());
    }

    @Test
    public void testSearchByArtist_NoMatch() {
        List<Song> results = service.searchByArtist("Michael Jackson");
        assertTrue(results.isEmpty());
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> results = service.searchByAlbum("A Night at the Opera");
        assertEquals(1, results.size());
        assertEquals("Bohemian Rhapsody", results.get(0).getTitle());
    }

    @Test
    public void testSearchByAlbum_MultipleMatches() {
        List<Song> results = service.searchByAlbum("Led Zeppelin");
        assertEquals(1, results.size());
        assertEquals("Stairway to Heaven", results.get(0).getTitle());
    }

    @Test
    public void testSearchByAlbum_NoMatch() {
        List<Song> results = service.searchByAlbum("Thriller");
        assertTrue(results.isEmpty());
    }

    @Test
    public void testSimulateServerCall_DelaysExecution() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        service.searchById(1);
        long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) >= 1000);
    }

    private record MockSongDatabase(List<Song> songs) implements SongDatabaseInterface {
    }

}

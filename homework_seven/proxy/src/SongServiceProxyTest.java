import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SongServiceProxyTest {

    private SongDatabaseInterface songDatabase;
    private SongService songService;
    private SongServiceProxy proxy;
    private List<Song> songs;

    @BeforeEach
    public void setUp() {
        songs = new ArrayList<>();
        songs.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera"));
        songs.add(new Song(2, "Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV"));

        songDatabase = new MockSongDatabase(songs);
        songService = new SongServiceServer(songDatabase);
        proxy = new SongServiceProxy(songService);
    }

    @Test
    public void testSearchByIdCacheTest() {
        //assert this takes longer than the next call
        long start = System.currentTimeMillis();
        Song song1 = proxy.searchById(1);
        long end = System.currentTimeMillis();
        assertTrue(end - start >= 1000);
        long firstCallTime = end - start;
        assertNotNull(song1);
        assertEquals("Bohemian Rhapsody", song1.getTitle());

        start = System.currentTimeMillis();
        Song song2 = proxy.searchById(1);
        end = System.currentTimeMillis();
        assertTrue(end - start < 1000);
        long secondCallTime = end - start;
        assertNotNull(song2);
        assertEquals("Bohemian Rhapsody", song2.getTitle());
        assert(secondCallTime < firstCallTime);
        assertSame(song1, song2);
    }


    @Test
    public void testSearchByTitleCacheTest() {
        //assert this takes longer than the next call
        long start = System.currentTimeMillis();
        List<Song> results1 = proxy.searchByTitle("Stairway");
        long end = System.currentTimeMillis();
        assertTrue(end - start >= 1000);
        long firstCallTime = end - start;
        assertEquals(1, results1.size());
        assertEquals("Stairway to Heaven", results1.get(0).getTitle());

        start = System.currentTimeMillis();
        List<Song> results2 = proxy.searchByTitle("Stairway");
        end = System.currentTimeMillis();
        assertTrue(end - start < 1000);
        long secondCallTime = end - start;
        assertEquals(1, results2.size());
        assertEquals("Stairway to Heaven", results2.get(0).getTitle());
        assert(secondCallTime < firstCallTime);
        assertSame(results1, results2);
    }

    @Test
    public void testSearchByArtistCacheTest() {
        //assert this takes longer than the next call
        long start = System.currentTimeMillis();
        List<Song> results1 = proxy.searchByArtist("Queen");
        long end = System.currentTimeMillis();
        assertTrue(end - start >= 1000);
        long firstCallTime = end - start;
        assertEquals(1, results1.size());
        assertEquals("Bohemian Rhapsody", results1.get(0).getTitle());

        start = System.currentTimeMillis();
        List<Song> results2 = proxy.searchByArtist("Queen");
        end = System.currentTimeMillis();
        assertTrue(end - start < 1000);
        long secondCallTime = end - start;
        assertEquals(1, results2.size());
        assertEquals("Bohemian Rhapsody", results2.get(0).getTitle());
        assert(secondCallTime < firstCallTime);
        assertSame(results1, results2);
    }

    @Test
    public void testSearchByAlbumCacheTest() {
        //assert this takes longer than the next call
        long start = System.currentTimeMillis();
        List<Song> results1 = proxy.searchByAlbum("A Night at the Opera");
        long end = System.currentTimeMillis();
        assertTrue(end - start >= 1000);
        long firstCallTime = end - start;
        assertEquals(1, results1.size());
        assertEquals("Bohemian Rhapsody", results1.get(0).getTitle());

        start = System.currentTimeMillis();
        List<Song> results2 = proxy.searchByAlbum("A Night at the Opera");
        end = System.currentTimeMillis();
        assertTrue(end - start < 1000);
        long secondCallTime = end - start;
        assertEquals(1, results2.size());
        assertEquals("Bohemian Rhapsody", results2.get(0).getTitle());
        assert(secondCallTime < firstCallTime);
        assertSame(results1, results2);
    }


    private record MockSongDatabase(List<Song> songs) implements SongDatabaseInterface {
        @Override
        public List<Song> songs() {
            return songs;
        }
    }
}


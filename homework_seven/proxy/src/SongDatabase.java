import java.util.ArrayList;
import java.util.List;

public class SongDatabase implements SongDatabaseInterface {
    private static final List<Song> songs = new ArrayList<>();

    static {
        songs.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera"));
        songs.add(new Song(2, "Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV"));
        songs.add(new Song(3, "Hotel California", "Eagles", "Hotel California"));
        songs.add(new Song(4, "Imagine", "John Lennon", "Imagine"));
        songs.add(new Song(5, "What's Going On", "Marvin Gaye", "What's Going On"));
        songs.add(new Song(6, "Born to Run", "Bruce Springsteen", "Born to Run"));
        songs.add(new Song(7, "Paint It Black", "The Rolling Stones", "Aftermath"));
        songs.add(new Song(8, "Purple Haze", "Jimi Hendrix", "Are You Experienced"));
        songs.add(new Song(9, "Dancing Queen", "ABBA", "Arrival"));
        songs.add(new Song(10, "The Climb", "Miley Cyrus", "Hannah Montana: The Movie"));
        songs.add(new Song(11, "Wrecking Ball", "Miley Cyrus", "Bangerz"));
        songs.add(new Song(12, "Party in the U.S.A.", "Miley Cyrus", "The Time of Our Lives"));
        songs.add(new Song(13, "We Can't Stop", "Miley Cyrus", "Bangerz"));
    }

    public List<Song> songs() {
        return songs;
    }
}

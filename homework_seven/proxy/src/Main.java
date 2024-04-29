public class Main {
    public static void main(String[] args) {
        SongService songServiceServer = new SongServiceServer(new SongDatabase());
        SongService songServiceProxy = new SongServiceProxy(songServiceServer);


        System.out.println("First call to searchById(1):");
        long start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchById(1));
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("\nSecond call to searchById(1):");
        start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchById(1));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("\nFirst call to searchByTitle(\"The Climb\"):");
        start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchByTitle("The Climb"));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("\nSecond call to searchByTitle(\"The Climb\"):");
        start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchByTitle("The Climb"));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("\nFirst call to searchByArtist(\"Miley Cyrus\"):");
        start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchByArtist("Miley Cyrus"));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("\nSecond call to searchByArtist(\"Miley Cyrus\"):");
        start = System.currentTimeMillis();
        System.out.println(songServiceProxy.searchByArtist("Miley Cyrus"));
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

    }
}
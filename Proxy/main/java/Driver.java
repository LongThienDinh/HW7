import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongService realService = new Service();
        Proxy proxyService = new Proxy(realService);

        System.out.println("Search by ID");
        System.out.println("Querying song ID: 3");
        Song songById = proxyService.searchById(3);
        System.out.println("Found: " + songById.getTitle() + " - " + songById.getArtist());
        System.out.println("Querying song ID: 3 again (use cache):");
        Song repeatedSongById = proxyService.searchById(3);
        System.out.println("Found from cache: " + repeatedSongById.getTitle() + " - " + repeatedSongById.getArtist());

        System.out.println("\nSearch by Title");
        System.out.println("Querying title: 'Roar'");
        List<Song> songsByTitle = proxyService.searchByTitle("Roar");
        songsByTitle.forEach(song -> System.out.println("Located: " + song.getTitle() + " - " + song.getArtist()));
        System.out.println("Querying title: 'Roar' again (use cache):");
        List<Song> repeatedSongsByTitle = proxyService.searchByTitle("Roar");
        repeatedSongsByTitle.forEach(song -> System.out.println("Located from cache: " + song.getTitle() + " - " + song.getArtist()));

        System.out.println("\nSearch by Album");
        System.out.println("Querying album: '1989'");
        List<Song> songsByAlbum = proxyService.searchByAlbum("1989");
        songsByAlbum.forEach(song -> System.out.println("Discovered: " + song.getTitle() + " - " + song.getArtist()));
        System.out.println("Querying album: '1989' again (use cache):");
        List<Song> repeatedSongsByAlbum = proxyService.searchByAlbum("1989");
        repeatedSongsByAlbum.forEach(song -> System.out.println("Discovered from cache: " + song.getTitle() + " - " + song.getArtist()));
    }
}

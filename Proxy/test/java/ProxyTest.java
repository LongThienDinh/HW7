import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ProxyTest {
    private Service realService;
    private Proxy proxy;

    @BeforeEach
    public void setUp() {
        realService = new Service();
        proxy = new Proxy(realService);
    }

    @Test
    public void testSearchByIdCacheHit() {
        Song expectedSong = new Song("Believer", "Imagine Dragons", "Evolve", 204);
        proxy.searchById(2);
        Song song = proxy.searchById(2);

        Assertions.assertEquals(expectedSong.getTitle(), song.getTitle(), "Cache should return the correct song title.");
        Assertions.assertEquals(expectedSong.getArtist(), song.getArtist(), "Cache should return the correct artist.");
    }

    @Test
    public void testSearchByTitleCacheHit() {
        List<Song> songs = proxy.searchByTitle("Roar");
        List<Song> cachedSongs = proxy.searchByTitle("Roar");

        Assertions.assertFalse(songs.isEmpty(), "Songs list should not be empty.");
        Assertions.assertEquals(songs.size(), cachedSongs.size(), "Cache should return the same list size.");
        Assertions.assertEquals(songs.get(0).getTitle(), cachedSongs.get(0).getTitle(), "Cache should return the correct song title.");
    }

    @Test
    public void testSearchByAlbumCacheHit() {
        List<Song> songs = proxy.searchByAlbum("1989");
        List<Song> cachedSongs = proxy.searchByAlbum("1989");

        Assertions.assertFalse(songs.isEmpty(), "Songs list should not be empty.");
        Assertions.assertEquals(songs.size(), cachedSongs.size(), "Cache should return the same list size.");
        Assertions.assertEquals(songs.get(0).getAlbum(), cachedSongs.get(0).getAlbum(), "Cache should return the correct album.");
    }
}

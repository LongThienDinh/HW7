import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ServiceTest {
    private Service service;

    @Before
    public void setUp() {
        service = new Service();
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> result = service.searchByAlbum("1989");
        assertEquals(1, result.size());
        assertEquals("Shake It Off", result.get(0).getTitle());
    }

    @Test
    public void testSearchByTitle() {
        List<Song> result = service.searchByTitle("Roar");
        assertEquals(1, result.size());
        assertEquals("Katy Perry", result.get(0).getArtist());
    }

    @Test
    public void testSearchByIdValid() {
        Song result = service.searchById(3);
        assertNotNull(result);
        assertEquals("Lose Yourself", result.getTitle());
    }

    @Test
    public void testSearchByIdInvalid() {
        Song result = service.searchById(10);
        assertNull(result);
    }
}

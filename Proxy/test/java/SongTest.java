import static org.junit.Assert.*;
import org.junit.Test;

public class SongTest {

    @Test
    public void testSongConstructorAndGetters() {
        Song song = new Song("Shape of You", "Ed Sheeran", "÷", 263);
        assertEquals("Shape of You", song.getTitle());
        assertEquals("Ed Sheeran", song.getArtist());
        assertEquals("÷", song.getAlbum());
        assertEquals(263, song.getDuration());
    }
}

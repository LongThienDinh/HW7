import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Proxy implements SongService {
    private SongService realService;
    private Map<Integer, Song> idCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;

    public Proxy(SongService realService) {
        this.realService = realService;
        this.idCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        album = album.toLowerCase();
        if (albumCache.containsKey(album)) {
            System.out.println("Cache hit for album: \"" + album + "\".");
            return albumCache.get(album);
        } else {
            System.out.println("Cache miss for album: \"" + album + "\". Querying server...");
            List<Song> songs = realService.searchByAlbum(album);
            albumCache.put(album, songs);
            return songs;
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        title = title.toLowerCase();
        if (titleCache.containsKey(title)) {
            System.out.println("Cache hit for title: \"" + title + "\".");
            return titleCache.get(title);
        } else {
            System.out.println("Cache miss for title: \"" + title + "\". Querying server...");
            List<Song> songs = realService.searchByTitle(title);
            titleCache.put(title, songs);
            return songs;
        }
    }

    @Override
    public Song searchById(Integer songID) {
        if (idCache.containsKey(songID)) {
            System.out.println("Cache hit for song ID: " + songID + ".");
            return idCache.get(songID);
        } else {
            System.out.println("Cache miss for song ID: " + songID + ". Querying server...");
            Song song = realService.searchById(songID);
            if(song != null) {
                idCache.put(songID, song);
            }
            return song;
        }
    }
}

import java.util.List;

public interface SongService {
    List<Song> searchByAlbum(String album);
    List<Song> searchByTitle(String title);
    Song searchById(Integer songID);

}
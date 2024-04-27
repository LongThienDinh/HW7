import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service implements SongService {
    private List<Song> listOfSongs;

    public Service() {
        this.listOfSongs = new ArrayList<>();
        listOfSongs.add(new Song("Shake It Off", "Taylor Swift", "1989", 242));
        listOfSongs.add(new Song("Thinking Out Loud", "Ed Sheeran", "x", 281));
        listOfSongs.add(new Song("Believer", "Imagine Dragons", "Evolve", 204));
        listOfSongs.add(new Song("Lose Yourself", "Eminem", "8 Mile", 326));
        listOfSongs.add(new Song("Shape of You", "Ed Sheeran", "÷", 263));
        listOfSongs.add(new Song("Roar", "Katy Perry", "Prism", 224));
        listOfSongs.add(new Song("Can't Stop the Feeling!", "Justin Timberlake", "Trolls", 230));
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listOfSongs.stream()
                .filter(song -> song.getAlbum().equalsIgnoreCase(album))
                .collect(Collectors.toList());
    }
    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listOfSongs.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (songID >= 0 && songID < listOfSongs.size()) {
            return listOfSongs.get(songID);
        }
        return null;
    }
}

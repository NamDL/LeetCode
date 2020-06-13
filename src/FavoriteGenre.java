import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteGenre {
    public static void main(String[] args) {
        Map<String, List<String>> user = new HashMap<>();
        user.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        user.put("Emma", Arrays.asList("song5", "song6", "song7"));
        Map<String, List<String>> genre = new HashMap<>();
        genre.put("Rock",Arrays.asList("song1", "song3"));
        genre.put("Dubstep",Arrays.asList("song7"));
        genre.put("Techno",Arrays.asList("song2", "song4"));
        genre.put("Pop",Arrays.asList("song5", "song6"));
        genre.put("Jazz",Arrays.asList("song8", "song9"));
    }
}

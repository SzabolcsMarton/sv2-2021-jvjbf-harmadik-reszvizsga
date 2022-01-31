package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MovieTheatreService {

    private Map<String, List<Movie>> moviesPerTheater = new TreeMap<>();

    public void readFromFile(Path path) {

            try {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines)
                {
                     String[] arr = line.split(":");
                     int minutes = Integer.parseInt(arr[1]);
                    String[] arr2 = arr[0].split(";");
                    int hours = Integer.parseInt(arr2[1]);
                    String[] arr3 = arr2[0].split("-");
                    String title = arr3[1];
                    String movieName = arr3[0];

                    if (!moviesPerTheater.containsKey(movieName)) {
                        moviesPerTheater.put(movieName, new ArrayList<>());
                    }

                    moviesPerTheater.get(movieName).add(new Movie(title, LocalTime.of(hours, minutes)));
                }
            }catch (IOException ioe){

            }
    }

    public Map<String, List<Movie>> getShows() {
        return moviesPerTheater;
    }


    public List<String> findMovie(String title) {
        return moviesPerTheater.entrySet().stream().filter((e)-> e.getValue().stream().anyMatch(m -> m.getTitle().equals(title))).map(e -> e.getKey()).toList();
    }
}

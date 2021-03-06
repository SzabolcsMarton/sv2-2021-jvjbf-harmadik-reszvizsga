package movietheatres;

import java.time.LocalTime;
import java.util.Objects;

public class Movie {

    private LocalTime startTime;
    private String title;

    public Movie(String title, LocalTime startTime) {
        this.title = title;
        this.startTime = startTime;
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return title.equals(movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

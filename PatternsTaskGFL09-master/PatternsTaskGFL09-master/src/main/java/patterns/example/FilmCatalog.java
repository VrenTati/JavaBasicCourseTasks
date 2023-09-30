package patterns.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Singleton Pattern - єдиний каталог фільмів
class FilmCatalog {
    private static FilmCatalog instance;
    private List<Film> films;

    private FilmCatalog() {
        films = new ArrayList<>();
    }

    public static FilmCatalog getInstance() {
        if (instance == null) {
            instance = new FilmCatalog();
        }
        return instance;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public List<Film> getFilms() {
        return films;

    }

    public List<Film> searchFilmsByGenre(String genre) {
        return films.stream()
                .filter(film -> film.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Film> searchFilmsByYear(int year) {
        return films.stream()
                .filter(film -> film.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Film> getAllFilms() {
        return films;
    }


    public void setFilms(List<Film> newFilms) {
        films = newFilms;
    }
}

package patterns.example;

// Factory Method Pattern - фабрика для створення фільмів різних жанрів
interface FilmFactory {
    Film createFilm(String title, int year);
}

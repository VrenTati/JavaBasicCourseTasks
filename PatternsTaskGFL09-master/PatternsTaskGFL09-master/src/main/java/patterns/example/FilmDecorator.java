package patterns.example;

// Decorator Pattern - додавання характеристик до фільмів
abstract class FilmDecorator extends Film {
    protected Film decoratedFilm;

    public FilmDecorator(Film decoratedFilm) {
        super(decoratedFilm.getTitle(), decoratedFilm.getYear(), decoratedFilm.getGenre());
        this.decoratedFilm = decoratedFilm;
    }

    public abstract String getAdditionalInfo();
}

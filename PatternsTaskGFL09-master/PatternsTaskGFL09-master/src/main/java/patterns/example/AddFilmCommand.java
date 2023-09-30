package patterns.example;

class AddFilmCommand implements Command {
    private FilmCatalog catalog;
    private Film film;

    public AddFilmCommand(FilmCatalog catalog, Film film) {
        this.catalog = catalog;
        this.film = film;
    }

    @Override
    public void execute() {
        catalog.addFilm(film);
    }
}

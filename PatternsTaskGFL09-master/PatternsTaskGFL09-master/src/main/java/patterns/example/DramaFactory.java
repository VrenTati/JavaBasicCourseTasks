package patterns.example;

class DramaFactory implements FilmFactory {
    @Override
    public Film createFilm(String title, int year) {
        return new Film(title, year, "Drama");
    }
}

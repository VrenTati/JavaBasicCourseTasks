package patterns.example;

class ComedyFactory implements FilmFactory {
    @Override
    public Film createFilm(String title, int year) {
        return new Film(title, year, "Comedy");
    }
}

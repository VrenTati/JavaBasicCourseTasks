package patterns.example;

class CountryDecorator extends FilmDecorator {
    private String country;

    public CountryDecorator(Film decoratedFilm, String country) {
        super(decoratedFilm);
        this.country = country;
    }

    @Override
    public String getAdditionalInfo() {
        return "Country: " + country;
    }
}

package patterns.example;

import java.util.List;
import java.util.Scanner;



/*public class Main {
    public static void main(String[] args) {
        FilmCatalog catalog = FilmCatalog.getInstance();
        catalog.addFilm(new Film("The Shawshank Redemption", 1994, "Drama"));
        catalog.addFilm(new Film("The Godfather", 1972, "Crime"));
        catalog.addFilm(new Film("Pulp Fiction", 1994, "Crime"));
        catalog.addFilm(new Film("The Dark Knight", 2008, "Action"));
        catalog.addFilm(new Film("Forrest Gump", 1994, "Drama"));
        catalog.addFilm(new Film("The Matrix", 1999, "Action"));
        catalog.addFilm(new Film("The Silence of the Lambs", 1991, "Crime"));
        catalog.addFilm(new Film("The Lord of the Rings: The Return of the King", 2003, "Adventure"));
        catalog.addFilm(new Film("Gladiator", 2000, "Action"));
        catalog.addFilm(new Film("The Shawshank Redemption", 1994, "Drama"));

        List<Film> films = catalog.getAllFilms();

        FileFilmCatalogAdapter fileAdapter = new FileFilmCatalogAdapter("D:\\f1.txt");
        fileAdapter.saveFilms(films);

        List<Film> films1 = fileAdapter.loadFilms();

        List<Film> dramaFilms = catalog.searchFilmsByGenre("Drama");
        for (Film film : dramaFilms) {
            System.out.println("Drama Film: " + film.getTitle());
        }

        List<Film> year1994Films = catalog.searchFilmsByYear(1994);
        for (Film film : year1994Films) {
            System.out.println("Films from 1994: " + film.getTitle());
        }

        for (Film film : films1) {
            System.out.println("Title: " + film.getTitle());
            System.out.println("Year: " + film.getYear());
            System.out.println("Genre: " + film.getGenre());
        }
    }
}*/

public class Main {
    public static void main(String[] args) {
        FilmCatalog catalog = FilmCatalog.getInstance();
        FileFilmCatalogAdapter fileAdapter = new FileFilmCatalogAdapter("D:\\f1.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Додати фільм");
            System.out.println("2. Переглянути всі фільми");
            System.out.println("3. Пошук за жанром");
            System.out.println("4. Пошук за роком");
            System.out.println("5. Завантажити фільми з файлу");
            System.out.println("6. Вийти");

            System.out.print("Будь ласка, виберіть опцію: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    System.out.print("Введіть назву фільму: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть рік фільму: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть жанр фільму: ");
                    String genre = scanner.nextLine();
                    catalog.addFilm(new Film(title, year, genre));
                    break;
                case 2:
                    List<Film> films = catalog.getAllFilms();
                    for (Film film : films) {
                        System.out.println("Назва: " + film.getTitle());
                        System.out.println("Рік: " + film.getYear());
                        System.out.println("Жанр: " + film.getGenre());
                    }
                    break;
                case 3:
                    System.out.print("Введіть жанр для пошуку: ");
                    String searchGenre = scanner.nextLine();
                    List<Film> dramaFilms = catalog.searchFilmsByGenre("Drama");
                    for (Film film : dramaFilms) {
                        System.out.println("Drama Film: " + film.getTitle());
                    }
                    break;
                case 4:
                    System.out.print("Введіть рік для пошуку: ");
                    int searchYear = scanner.nextInt();
                    scanner.nextLine();
                    List<Film> year1994Films = catalog.searchFilmsByYear(1994);
                    for (Film film : year1994Films) {
                        System.out.println("Films from 1994: " + film.getTitle());
                    }

                case 5:
                    List<Film> loadedFilms = fileAdapter.loadFilms();
                    catalog.setFilms(loadedFilms);
                    System.out.println("Фільми були завантажені з файлу.");
                    break;
                case 6:
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір. Будь ласка, виберіть іншу опцію.");
            }
        } while (choice != 6);


        fileAdapter.saveFilms(catalog.getAllFilms());
    }
}






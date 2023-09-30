package patterns.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileFilmCatalogAdapter implements Serializable{
    private String filePath;

    public FileFilmCatalogAdapter(String filePath) {
        this.filePath = filePath;
    }

    public void saveFilms(List<Film> films) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(films);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Film> loadFilms() {
        List<Film> films = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            films = (List<Film>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return films;
    }
}
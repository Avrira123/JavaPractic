package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    private final Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void saveUniversityToJson(University university, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        }
    }

    public University loadUniversityFromJson(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        }
    }
}
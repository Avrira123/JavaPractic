import controller.JsonManager;
import model.University;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        JsonManager jsonManager = new JsonManager();
        String filePath = "test_university.json";

        try {
            University university = jsonManager.loadUniversityFromJson(filePath);
            System.out.println(university);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
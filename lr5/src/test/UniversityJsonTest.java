package test;

import controller.*;
import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityJsonTest {

    @Test
    public void testUniversityJson() throws IOException {
        University oldUniversity = createTestUniversity();
        JsonManager jsonManager = new JsonManager();
        String filePath = "test_university.json";

        jsonManager.saveUniversityToJson(oldUniversity, filePath);
        University newUniversity = jsonManager.loadUniversityFromJson(filePath);

        assertEquals(oldUniversity, newUniversity);
    }

    private University createTestUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        HumanCreator humanCreator = new HumanCreator();
        FacultyCreator facultyCreator = new FacultyCreator();

        Human rector = humanCreator.createHuman("Іван", "Петренко", "Сидорович", Sex.MALE);
        University university = universityCreator.createUniversity("Тестовий Університет", rector);

        Human dean1 = humanCreator.createHuman("Олена", "Іванова", "Андріївна", Sex.FEMALE);
        Faculty faculty1 = facultyCreator.createFaculty("Факультет 1", dean1);
        university.addFaculty(faculty1);

        return university;
    }
}
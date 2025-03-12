package main;

import controller.JsonManager;
import controller.HumanCreator;
import controller.StudentCreator;
import controller.GroupCreator;
import controller.DepartmentCreator;
import controller.FacultyCreator;
import controller.UniversityCreator;
import model.*;

import java.io.IOException;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        System.out.println(university);

        JsonManager jsonManager = new JsonManager();
        String filePath = "university.json";

        try {
            jsonManager.saveUniversityToJson(university, filePath);
            System.out.println("University saved to JSON.");

            University loadedUniversity = jsonManager.loadUniversityFromJson(filePath);
            System.out.println("University loaded from JSON.");
            System.out.println(loadedUniversity);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        Human rector = humanCreator.createHuman("Іван", "Петренко", "Сидорович", Sex.MALE);
        University university = universityCreator.createUniversity("Київський Національний Університет", rector);

        Human dean1 = humanCreator.createHuman("Олена", "Іванова", "Андріївна", Sex.FEMALE);
        Faculty faculty1 = facultyCreator.createFaculty("Факультет Інформаційних Технологій", dean1);
        university.addFaculty(faculty1);

        Human headDepartment1 = humanCreator.createHuman("Петро", "Сидоров", "Олексійович", Sex.MALE);
        Department department1 = departmentCreator.createDepartment("Кафедра Програмної Інженерії", headDepartment1);
        faculty1.addDepartment(department1);

        Human headGroup1 = humanCreator.createHuman("Анна", "Коваленко", "Миколаївна", Sex.FEMALE);
        Group group1 = groupCreator.createGroup("ІП-11", headGroup1);
        department1.addGroup(group1);

        Student student1 = studentCreator.createStudent("Дмитро", "Павленко", "Сергійович", Sex.MALE);
        Student student2 = studentCreator.createStudent("Марія", "Лисенко", "Олександрівна", Sex.FEMALE);
        group1.addStudent(student1);
        group1.addStudent(student2);

        return university;
    }
}
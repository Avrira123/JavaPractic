package test;

import controller.JsonManager;
import controller.UniversityCreator;
import controller.HumanCreator;
import controller.FacultyCreator;
import controller.DepartmentCreator;
import controller.GroupCreator;
import controller.StudentCreator;
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
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        Human rector = humanCreator.createHuman("Іван", "Петренко", "Сидорович", Sex.MALE);
        University university = universityCreator.createUniversity("Тестовий Університет", rector);

        Human dean1 = humanCreator.createHuman("Олена", "Іванова", "Андріївна", Sex.FEMALE);
        Faculty faculty1 = facultyCreator.createFaculty("Факультет 1", dean1);
        university.addFaculty(faculty1);

        Human dean2 = humanCreator.createHuman("Петро", "Сидоров", "Олексійович", Sex.MALE);
        Faculty faculty2 = facultyCreator.createFaculty("Факультет 2", dean2);
        university.addFaculty(faculty2);

        Human headDepartment11 = humanCreator.createHuman("Анна", "Коваленко", "Миколаївна", Sex.FEMALE);
        Department department11 = departmentCreator.createDepartment("Кафедра 1.1", headDepartment11);
        faculty1.addDepartment(department11);

        Human headDepartment12 = humanCreator.createHuman("Сергій", "Лисенко", "Дмитрович", Sex.MALE);
        Department department12 = departmentCreator.createDepartment("Кафедра 1.2", headDepartment12);
        faculty1.addDepartment(department12);

        Human headDepartment21 = humanCreator.createHuman("Марія", "Павленко", "Олександрівна", Sex.FEMALE);
        Department department21 = departmentCreator.createDepartment("Кафедра 2.1", headDepartment21);
        faculty2.addDepartment(department21);

        Human headDepartment22 = humanCreator.createHuman("Дмитро", "Мельник", "Андрійович", Sex.MALE);
        Department department22 = departmentCreator.createDepartment("Кафедра 2.2", headDepartment22);
        faculty2.addDepartment(department22);

        Human headGroup111 = humanCreator.createHuman("Наталія", "Шевченко", "Іванівна", Sex.FEMALE);
        Group group111 = groupCreator.createGroup("Група 1.1.1", headGroup111);
        department11.addGroup(group111);

        Human headGroup112 = humanCreator.createHuman("Віталій", "Бондаренко", "Петрович", Sex.MALE);
        Group group112 = groupCreator.createGroup("Група 1.1.2", headGroup112);
        department11.addGroup(group112);

        Human headGroup121 = humanCreator.createHuman("Оксана", "Ткаченко", "Сергіївна", Sex.FEMALE);
        Group group121 = groupCreator.createGroup("Група 1.2.1", headGroup121);
        department12.addGroup(group121);

        Human headGroup122 = humanCreator.createHuman("Андрій", "Кравченко", "Олексійович", Sex.MALE);
        Group group122 = groupCreator.createGroup("Група 1.2.2", headGroup122);
        department12.addGroup(group122);

        Human headGroup211 = humanCreator.createHuman("Юлія", "Ковальчук", "Миколаївна", Sex.FEMALE);
        Group group211 = groupCreator.createGroup("Група 2.1.1", headGroup211);
        department21.addGroup(group211);

        Human headGroup212 = humanCreator.createHuman("Роман", "Волошин", "Дмитрович", Sex.MALE);
        Group group212 = groupCreator.createGroup("Група 2.1.2", headGroup212);
        department21.addGroup(group212);

        Human headGroup221 = humanCreator.createHuman("Ірина", "Захарчук", "Андріївна", Sex.FEMALE);
        Group group221 = groupCreator.createGroup("Група 2.2.1", headGroup221);
        department22.addGroup(group221);

        Human headGroup222 = humanCreator.createHuman("Олег", "Поліщук", "Сергійович", Sex.MALE);
        Group group222 = groupCreator.createGroup("Група 2.2.2", headGroup222);
        department22.addGroup(group222);

        Student student1111 = studentCreator.createStudent("Олександр", "Іванов", "Петрович", Sex.MALE);
        Student student1112 = studentCreator.createStudent("Катерина", "Сидорова", "Андріївна", Sex.FEMALE);
        group111.addStudent(student1111);
        group111.addStudent(student1112);

        Student student1121 = studentCreator.createStudent("Віктор", "Лисенко", "Сергійович", Sex.MALE);
        Student student1122 = studentCreator.createStudent("Анастасія", "Коваленко", "Миколаївна", Sex.FEMALE);
        group112.addStudent(student1121);
        group112.addStudent(student1122);

        Student student1211 = studentCreator.createStudent("Павло", "Ткаченко", "Олексійович", Sex.MALE);
        Student student1212 = studentCreator.createStudent("Софія", "Кравченко", "Дмитрівна", Sex.FEMALE);
        group121.addStudent(student1211);
        group121.addStudent(student1212);

        Student student1221 = studentCreator.createStudent("Юрій", "Шевченко", "Іванович", Sex.MALE);
        Student student1222 = studentCreator.createStudent("Марія", "Бондаренко", "Петрівна", Sex.FEMALE);
        group122.addStudent(student1221);
        group122.addStudent(student1222);

        Student student2111 = studentCreator.createStudent("Ігор", "Ковальчук", "Миколайович", Sex.MALE);
        Student student2112 = studentCreator.createStudent("Ольга", "Волошина", "Дмитрівна", Sex.FEMALE);
        group211.addStudent(student2111);
        group211.addStudent(student2112);

        Student student2121 = studentCreator.createStudent("Максим", "Захарчук", "Андрійович", Sex.MALE);
        Student student2122 = studentCreator.createStudent("Людмила", "Поліщук", "Сергіївна", Sex.FEMALE);
        group212.addStudent(student2121);
        group212.addStudent(student2122);

        Student student2211 = studentCreator.createStudent("Артем", "Демченко", "Олексійович", Sex.MALE);
        Student student2212 = studentCreator.createStudent("Валентина", "Савчук", "Миколаївна", Sex.FEMALE);
        group221.addStudent(student2212);

        Student student2221 = studentCreator.createStudent("Віталій", "Петров", "Ігорович", Sex.MALE);
        Student student2222 = studentCreator.createStudent("Олена", "Козак", "Сергіївна", Sex.FEMALE);
        group222.addStudent(student2221);
        group222.addStudent(student2222);

        return university;
    }
}
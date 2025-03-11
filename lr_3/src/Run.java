package main;

import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        System.out.println(university);
        university.getFaculties().forEach(System.out::println);
        university.getFaculties().get(0).getDepartments().forEach(System.out::println);
        university.getFaculties().get(0).getDepartments().get(0).getGroups().forEach(System.out::println);
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
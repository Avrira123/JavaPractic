package controller;

import model.Human;
import model.Sex;
import model.Student;

public class StudentCreator {

    public Student createStudent(String name, String surname, String patronymic, Sex sex) {
        Human human = new Human(name, surname, patronymic, sex);
        return new Student(human);
    }
}
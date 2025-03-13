package model;

import java.util.Objects;

public class Student {
    private Human human;

    public Student(Human human) {
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(human, student.human);
    }

    @Override
    public int hashCode() {
        return Objects.hash(human);
    }

    @Override
    public String toString() {
        return "Student{" +
                "human=" + human +
                '}';
    }
}
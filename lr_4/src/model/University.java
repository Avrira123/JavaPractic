package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University() {
    }

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        this.faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University university = (University) o;
        return Objects.equals(name, university.name) &&
                Objects.equals(head, university.head) &&
                Objects.equals(faculties, university.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }

    @Override
    public String toString() {
        return "University: " + name + ", Head: " + head.getLastName();
    }
}
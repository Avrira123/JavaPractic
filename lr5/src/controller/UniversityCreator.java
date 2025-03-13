package controller;

import model.Human;
import model.University;

public class UniversityCreator {

    public University createUniversity(String name, Human rector) {
        return new University(name, rector);
    }
}
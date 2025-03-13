package controller;

import model.Human;
import model.Sex;

public class HumanCreator {

    public Human createHuman(String name, String surname, String patronymic, Sex sex) {
        return new Human(name, surname, patronymic, sex);
    }
}
package controller;

import model.Group;
import model.Human;

public class GroupCreator {

    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
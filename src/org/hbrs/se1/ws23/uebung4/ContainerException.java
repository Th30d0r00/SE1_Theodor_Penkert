package org.hbrs.se1.ws23.uebung4;

public class ContainerException extends Exception {
    ContainerException(UserStory userStory) {
        super("die User-Story mit der ID " + userStory.getId() + "ist bereits vorhanden!");
    }


}


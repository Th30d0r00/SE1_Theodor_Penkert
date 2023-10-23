package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception {
    ContainerException(Member member) {
        super("das Member-Objekt mit der ID " + member.getID() + "ist bereits vorhanden!");
    }


}

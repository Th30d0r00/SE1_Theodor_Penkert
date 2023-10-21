package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception {
    ContainerException(Member member) {
        super("Das Member-Objekt mit der ID " + member + "ist bereits vorhanden!");
    }


}

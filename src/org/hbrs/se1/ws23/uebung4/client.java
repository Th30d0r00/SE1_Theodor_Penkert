package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;

import java.io.IOException;

public class client {
    public static void main(String[] args) throws PersistenceException, IOException, ClassNotFoundException, ContainerException {
        EingabeDialog.startEingabe();
    }
}

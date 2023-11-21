package org.hbrs.se1.ws23.uebung4.test;

import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.ContainerException;
import org.hbrs.se1.ws23.uebung4.EingabeDialog;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class uebung4Test {

    Container container = Container.getInstance();

    @Test
    void eingabeTest() throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        EingabeDialog.startEingabe();
    }

}

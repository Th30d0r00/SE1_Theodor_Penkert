package org.hbrs.se1.ws23.uebung3.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class uebung3Test {
    Container c = Container.getInstance();

    @BeforeEach
    void setup() {
        c = Container.getInstance();
    }


    @Test
    void testPersistenceStrategyMongoDB() throws PersistenceException, IOException, ClassNotFoundException {
        PersistenceStrategyMongoDB p = new PersistenceStrategyMongoDB();
        c.setPersistenceStrategy(p);
        assertThrows(UnsupportedOperationException.class,() -> c.store());
    }

    @Test
    void testWrongLocation() throws PersistenceException, IOException {
        PersistenceStrategyStream p = new PersistenceStrategyStream();
        String l = "C:\\no\\such\\place\\";
        p.setLocation(l);
        c.setPersistenceStrategy(p);
        assertThrows(FileNotFoundException.class,() -> c.store());
    }

    @Test
    void roundTripTest() throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        ConcreteMember member = new ConcreteMember(1);
        c.addMember(member);
        assertEquals(1,c.size());
        PersistenceStrategyStream p = new PersistenceStrategyStream();
        c.setPersistenceStrategy(p);
        c.store();
        assertEquals(1,c.size());
        c.deleteMember(1);
        assertEquals(0,c.size());
        c.load();
        assertEquals(1,c.size());
    }

}

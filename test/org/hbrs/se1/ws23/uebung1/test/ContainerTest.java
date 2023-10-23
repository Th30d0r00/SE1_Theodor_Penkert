package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContainerTest {

    Container container = new Container();
    ConcreteMember member1 = new ConcreteMember(1);
    ConcreteMember member2 = new ConcreteMember(2);

    @BeforeEach
    void setup() {
        container = new Container();
    }

    @Test
    void containerTest() throws ContainerException {
        container.addMember(member1);
        assertEquals(1,container.size());
        container.addMember(member2);
        assertEquals(2,container.size());
        assertThrows(ContainerException.class, () -> container.addMember(member1));
        assertThrows(ContainerException.class, () -> container.addMember(member2));
        container.dump(); // Testet auf Ausgabe in der Konsole von den zwei Member Objekten
        assertEquals("id nicht vorhanden", container.deleteMember(5));
        assertEquals("erfolgreich gelöscht", container.deleteMember(1));
        assertEquals(1,container.size());
        assertEquals("erfolgreich gelöscht", container.deleteMember(2));
        assertEquals(0,container.size());

    }


}

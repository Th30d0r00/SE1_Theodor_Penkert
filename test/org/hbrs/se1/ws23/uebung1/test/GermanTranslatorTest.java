package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws23.uebung1.view.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(5);
        assertEquals(value, "fuenf");
    }

    @Test
    void anegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(0);
        assertEquals(value, "Uebersetzung der Zahl 0 nicht möglich (1.0)");
    }

    @Test
    void anegativeTest2() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(11);
        assertEquals(value, "Uebersetzung der Zahl 11 nicht möglich (1.0)");
    }

    @Test
    void anegativeTest3() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(-10);
        assertEquals(value, "Uebersetzung der Zahl -10 nicht möglich (1.0)");
    }

    @Test
    void aPositiveTest2() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(1);
        assertEquals(value, "eins");
    }

    @Test
    void aPositiveTest3() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(10);
        assertEquals(value, "zehn");
    }



}
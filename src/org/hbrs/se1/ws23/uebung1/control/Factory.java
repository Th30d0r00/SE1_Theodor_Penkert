package org.hbrs.se1.ws23.uebung1.control;

import org.hbrs.se1.ws23.uebung1.view.Client;


public class Factory {
    public static Translator create() {
        return new GermanTranslator();
    }


}

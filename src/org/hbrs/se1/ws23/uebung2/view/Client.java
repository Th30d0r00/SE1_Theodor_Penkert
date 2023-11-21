package org.hbrs.se1.ws23.uebung2.view;

import org.hbrs.se1.ws23.uebung2.*;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung4.UserStory;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws ContainerException, PersistenceException, IOException, ClassNotFoundException {
        //Erzeugung der Member Objekte
        ConcreteMember m1 = new ConcreteMember(1);
        ConcreteMember m2 = new ConcreteMember(2);
        ConcreteMember m3 = new ConcreteMember(3);

        //Erzeugung des Containers
        Container c = Container.getInstance();

        //Member Objekte hinzufügen
        c.addMember(m1);
        c.addMember(m2);
        c.addMember(m3);

        //MemberView erstellen
        MemberView memberView = new MemberView();

        //aktuelle Liste aus container auslesen
        List<Member> test = c.getCurrentList();

        //Ausgabe der Member Objekte durch Member View
        memberView.dump(test);


    }
}
